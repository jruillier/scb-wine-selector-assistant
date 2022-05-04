package domain.dataSourcePort

data class StoredItemDto(val label: String, val imageSrc: String?, val targetHref: String?, val children: List<StoredItemDto>) {}
