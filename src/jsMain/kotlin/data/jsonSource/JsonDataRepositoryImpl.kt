package data.jsonSource

import domain.dataSourcePort.DataRepository
import domain.dataSourcePort.StoredItemDto
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

class JsonDataRepositoryImpl : DataRepository {
    override suspend fun getItemsTree(): List<StoredItemDto> {
        val client = HttpClient() {
            install(JsonFeature)
        }
        val items = client.get<List<StoredItemDataDto>>("http://localhost:8080/items.wsa.json")
        console.log(items)

        return items.map { toDomainDto(it) }
    }

    private fun toDomainDto(dataDto: StoredItemDataDto): StoredItemDto =
        StoredItemDto(
            dataDto.label,
            dataDto.imageSrc,
            dataDto.targetHref,
            dataDto.children.map { toDomainDto(it) })
}