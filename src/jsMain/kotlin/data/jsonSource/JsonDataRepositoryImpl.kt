package data.jsonSource

import domain.dataSourcePort.DataRepository
import domain.dataSourcePort.StoredItemDto
import domain.usecase.GetChoicesUC
import domain.vo.WineSelectionStrategyEnum

class JsonDataRepositoryImpl : DataRepository {
    override fun getItemsTree(): List<StoredItemDto> {

        //TODO JR replace with real data here
        return listOf(
            StoredItemDto(
                WineSelectionStrategyEnum.ByTaste.label, GetChoicesUC.FAKE_IMG_SRC, null, listOf(
                    StoredItemDto(
                        "Fruité",
                        GetChoicesUC.FAKE_IMG_SRC,
                        "https://simplecommebacchus.fr/collections/alsace",
                        listOf()
                    ),
                    StoredItemDto(
                        "Souple et léger",
                        GetChoicesUC.FAKE_IMG_SRC,
                        "https://simplecommebacchus.fr/collections/bourgogne", listOf()
                    ),
                    StoredItemDto(
                        "Liquoreux / Sucré",
                        GetChoicesUC.FAKE_IMG_SRC,
                        "https://simplecommebacchus.fr/collections/beaujolais", listOf()
                    ),
                    StoredItemDto(
                        "Sec et Minéral",
                        GetChoicesUC.FAKE_IMG_SRC,
                        "https://simplecommebacchus.fr/collections/cote-du-rhone", listOf()
                    ),
                    StoredItemDto(
                        "Puissant",
                        GetChoicesUC.FAKE_IMG_SRC,
                        "https://simplecommebacchus.fr/collections/sud-ouest", listOf()
                    ),
                    StoredItemDto(
                        "Boisé",
                        GetChoicesUC.FAKE_IMG_SRC,
                        "https://simplecommebacchus.fr/collections/bordeaux",
                        listOf()
                    ),
                )
            ),
            StoredItemDto(
                WineSelectionStrategyEnum.ByMeal.label, GetChoicesUC.FAKE_IMG_SRC, null, listOf(
                    StoredItemDto(
                        "Apéritif", GetChoicesUC.FAKE_IMG_SRC, null, listOf(
                            StoredItemDto("Boudin", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Crevettes", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                        )
                    ),
                    StoredItemDto(
                        "Entrée", GetChoicesUC.FAKE_IMG_SRC, null, listOf(
                            StoredItemDto("Concombre", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Avocat", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Crabe farci", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                        )
                    ),
                    StoredItemDto(
                        "Plat Principal", GetChoicesUC.FAKE_IMG_SRC, null, listOf(
                            StoredItemDto("Colombo", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Cour-bouillon de poisson", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Viande grillée", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                        )
                    ),
                    StoredItemDto(
                        "Fromage", GetChoicesUC.FAKE_IMG_SRC, null, listOf(
                            StoredItemDto("Camembert", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Morbier", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Chèvre", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                        )
                    ),
                    StoredItemDto(
                        "Dessert", GetChoicesUC.FAKE_IMG_SRC, null, listOf(
                            StoredItemDto("Crème brulée", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Ananas", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                            StoredItemDto("Chocolat", GetChoicesUC.FAKE_IMG_SRC, null, listOf()),
                        )
                    ),
                )
            ),
        )
    }
}