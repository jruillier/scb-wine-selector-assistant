package domain.dataSourcePort

interface DataRepository {

    suspend fun getItemsTree(): List<StoredItemDto>

}