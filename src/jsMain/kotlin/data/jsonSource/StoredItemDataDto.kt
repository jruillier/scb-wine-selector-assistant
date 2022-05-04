package data.jsonSource

import kotlinx.serialization.Serializable

@Serializable
data class StoredItemDataDto(
    val label: String,
    val imageSrc: String?,
    val targetHref: String?,
    val children: List<StoredItemDataDto>
)
