package presentation.jbCompose

import androidx.compose.runtime.Composable
import domain.vo.ChoiceVO
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun BreadCrumb(selectedChoices: MutableList<ChoiceVO>) {
    Div({
        style {
        }
    }) {
        if (selectedChoices.isNotEmpty()) {
            A("#wine-selector", {
                title("Annuler")
                onClick {
                    selectedChoices.clear()
                }
                classes("more-link")
            }) {
                Text("<<")
            }
        }
    }

}