package data.jsonSource

import domain.configProviderPort.ConfigProviderPort
import domain.dataSourcePort.DataRepository
import domain.dataSourcePort.StoredItemDto
import domain.loggerPort.LoggerFactoryPort
import domain.loggerPort.LoggerPort
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

class JsonDataRepositoryImpl(loggerFactory: LoggerFactoryPort, private val configProvider: ConfigProviderPort) : DataRepository {

    val logger:LoggerPort = loggerFactory.getLogger(this::class)
    override suspend fun getItemsTree(): List<StoredItemDto> {
        val jsonUrl = configProvider.getStringConfig("json-url")!!

        this.logger.info("SCB Loading JSON from: $jsonUrl")

        val client = HttpClient() {
            install(JsonFeature)
        }
        val items = client.get<List<StoredItemDataDto>>(jsonUrl)

        this.logger.debug(items.toString())

        return items.map { toDomainDto(it) }
    }

    private fun toDomainDto(dataDto: StoredItemDataDto): StoredItemDto =
        StoredItemDto(
            dataDto.label,
            dataDto.imageSrc,
            dataDto.targetHref,
            dataDto.children.map { toDomainDto(it) })
}