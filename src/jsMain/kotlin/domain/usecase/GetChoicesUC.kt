package domain.usecase

import domain.vo.ChoiceVO
import domain.vo.WineSelectionStrategyEnum

class GetChoicesUC {

    companion object {
        const val FAKE_IMG_SRC =
            "https://cdn.shopify.com/s/files/1/0519/9049/5389/files/Nouveau_logo_scomb_0d11481b-eae4-46b4-9061-4913bdd29b04_600x.png?v=1630613396"
    }

    fun exec(rootChoice: ChoiceVO?): List<ChoiceVO> {

        console.log(rootChoice)

        if (rootChoice == null) {
            return listOf(
                ChoiceVO(WineSelectionStrategyEnum.ByTaste.label, FAKE_IMG_SRC, null),
                ChoiceVO(WineSelectionStrategyEnum.ByMeal.label, FAKE_IMG_SRC, null),
            );
        }
        if (rootChoice.label == WineSelectionStrategyEnum.ByTaste.label) {
            return listOf(
                ChoiceVO("Fruité", FAKE_IMG_SRC, "https://simplecommebacchus.fr/collections/alsace"),
                ChoiceVO("Souple et léger", FAKE_IMG_SRC, "https://simplecommebacchus.fr/collections/bourgogne"),
                ChoiceVO("Liquoreux / Sucré", FAKE_IMG_SRC, "https://simplecommebacchus.fr/collections/beaujolais"),
                ChoiceVO("Sec et Minéral", FAKE_IMG_SRC, "https://simplecommebacchus.fr/collections/cote-du-rhone"),
                ChoiceVO("Puissant", FAKE_IMG_SRC, "https://simplecommebacchus.fr/collections/sud-ouest"),
                ChoiceVO("Boisé", FAKE_IMG_SRC, "https://simplecommebacchus.fr/collections/bordeaux"),
            )
        }

        if (rootChoice.label == WineSelectionStrategyEnum.ByMeal.label) {
            return listOf(
                ChoiceVO("Apéritif", FAKE_IMG_SRC, null),
                ChoiceVO("Entrée", FAKE_IMG_SRC, null),
                ChoiceVO("Plat Principal", FAKE_IMG_SRC, null),
                ChoiceVO("Fromage", FAKE_IMG_SRC, null),
                ChoiceVO("Dessert", FAKE_IMG_SRC, null),
            )
        }

        if (rootChoice.label == "Apéritif") {
            return listOf(
                ChoiceVO("Boudin", FAKE_IMG_SRC, null),
                ChoiceVO("Crevettes", FAKE_IMG_SRC, null),
            )
        }
        if (rootChoice.label == "Entrée") {
            return listOf(
                ChoiceVO("Concombre", FAKE_IMG_SRC, null),
                ChoiceVO("Avocat", FAKE_IMG_SRC, null),
                ChoiceVO("Crabe farci", FAKE_IMG_SRC, null),
            )
        }
        if (rootChoice.label == "Plat Principal") {
            return listOf(
                ChoiceVO("Colombo", FAKE_IMG_SRC, null),
                ChoiceVO("Cour-bouillon de poisson", FAKE_IMG_SRC, null),
                ChoiceVO("Viande grillée", FAKE_IMG_SRC, null),
            )
        }
        if (rootChoice.label == "Fromage") {
            return listOf(
                ChoiceVO("Camembert", FAKE_IMG_SRC, null),
                ChoiceVO("Morbier", FAKE_IMG_SRC, null),
                ChoiceVO("Chèvre", FAKE_IMG_SRC, null),
            )
        }
        if (rootChoice.label == "Dessert") {
            return listOf(
                ChoiceVO("Crème brulée", FAKE_IMG_SRC, null),
                ChoiceVO("Ananas", FAKE_IMG_SRC, null),
                ChoiceVO("Chocolat", FAKE_IMG_SRC, null),
            )
        }

        return emptyList()
    }

}