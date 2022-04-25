package presentation.compose

import androidx.compose.runtime.*
import domain.vo.ChoiceVO
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun WineSelectorAssistant() {

    val selectedChoices: MutableList<ChoiceVO> = mutableStateListOf()

    Div({
        style {
            border(1.px, LineStyle.Solid, Color.black)
            padding(5.px)
        }
    }) {

        H3 { Text("Aidez moi à choisir mon vin...") }
        BreadCrumb(selectedChoices)

        ChoiceSelector(selectedChoices.lastOrNull(), onSelected = {selectedChoice->
            if (selectedChoice.targetHref != null) {
                window.location.href = selectedChoice.targetHref
                return@ChoiceSelector
            }
            selectedChoices.add(selectedChoice)
        })

    }

}
