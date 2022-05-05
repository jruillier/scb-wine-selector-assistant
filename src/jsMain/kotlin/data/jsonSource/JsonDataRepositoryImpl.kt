package data.jsonSource

import domain.dataSourcePort.DataRepository
import domain.dataSourcePort.StoredItemDto
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.browser.document

class JsonDataRepositoryImpl : DataRepository {
    override suspend fun getItemsTree(): List<StoredItemDto> {

        // TODO JR use a domain port instead of this
        val jsonUrl = document
            .getElementById("wine-selector")!!
            .getAttribute("data-json-url")!!

        console.log("SCB Loading JSON from: $jsonUrl")

        val client = HttpClient() {
            install(JsonFeature)
        }
        val items = client.get<List<StoredItemDataDto>>(jsonUrl)
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