package domain.usecase

import domain.dataSourcePort.DataRepository
import domain.dataSourcePort.StoredItemDto
import domain.vo.ChoiceVO

class GetChoicesUC(private val dataRepository: DataRepository) {

    companion object {
        const val FAKE_IMG_SRC =
            "https://cdn.shopify.com/s/files/1/0519/9049/5389/files/Nouveau_logo_scomb_0d11481b-eae4-46b4-9061-4913bdd29b04_600x.png?v=1630613396"
    }

    fun exec(rootChoice: ChoiceVO?): List<ChoiceVO> {

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