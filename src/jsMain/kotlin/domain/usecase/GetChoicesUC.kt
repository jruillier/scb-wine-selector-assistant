package domain.usecase

import domain.dataSourcePort.DataRepository
import domain.dataSourcePort.StoredItemDto
import domain.vo.ChoiceVO

class GetChoicesUC(private val dataRepository: DataRepository) {

    suspend fun exec(rootChoice: ChoiceVO?): List<ChoiceVO> {

        val allItemsTree = this.dataRepository.getItemsTree()

        if (rootChoice == null) {
            return allItemsTree.map(this::mapAsChoiceVO)
        }

        val found = this.findInTree(rootChoice.label, allItemsTree)
        return found.children.map(this::mapAsChoiceVO)
    }

    private fun mapAsChoiceVO(itemDto: StoredItemDto): ChoiceVO {
        return ChoiceVO(itemDto.label, itemDto.imageSrc, itemDto.targetHref)
    }

    private fun findInTree(choiceLabel: String, itemsTree: List<StoredItemDto>): StoredItemDto {
        return itemsTree
            .flatMap(this::flattenChildren)
            .find { storedItemDto -> storedItemDto.label == choiceLabel }!!
    }

    private fun flattenChildren(itemDto: StoredItemDto): List<StoredItemDto> {
        val list = mutableListOf(itemDto)
        list.addAll(itemDto.children.flatMap(this::flattenChildren))
        return list
    }

}