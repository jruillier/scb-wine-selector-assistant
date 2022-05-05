package data.jsonSource

import domain.configProviderPort.ConfigProviderPort
import domain.dataSourcePort.DataRepository
import domain.dataSourcePort.StoredItemDto
import domain.loggerPort.LoggerPort
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

class JsonDataRepositoryImpl(val logger:LoggerPort, private val configProvider: ConfigProviderPort) : DataRepository {

    private var previousItems: List<StoredItemDto>? = null

    override suspend fun getItemsTree(): List<StoredItemDto> {
        if (this.previousItems != null) {
            return this.previousItems!!
        }

        val jsonUrl = configProvider.getStringConfig("json-url")!!

        this.logger.info("Loading items JSON from: $jsonUrl")

        val client = HttpClient() {
            install(JsonFeature)
        }
        val items = client.get<List<StoredItemDataDto>>(jsonUrl)

        this.logger.debug(items.toString())

        this.previousItems = items.map { toDomainDto(it) }
        return this.previousItems!!
    }

    private fun toDomainDto(dataDto: StoredItemDataDto): StoredItemDto =
        StoredItemDto(
            dataDto.label,
            dataDto.imageSrc,
            dataDto.targetHref,
            dataDto.children.map { toDomainDto(it) })
}