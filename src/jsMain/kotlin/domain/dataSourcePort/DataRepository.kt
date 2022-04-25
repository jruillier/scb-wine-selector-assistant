package domain.dataSourcePort

interface DataRepository {

    fun getItemsTree(): List<StoredItemDto>

}