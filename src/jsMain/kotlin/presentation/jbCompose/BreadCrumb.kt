package presentation.jbCompose

import androidx.compose.runtime.Composable
import domain.loggerPort.LoggerPort
import domain.vo.ChoiceVO
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@Composable
fun BreadCrumb(selectedChoices: MutableList<ChoiceVO>) {

    val logger: LoggerPort by localDI().instance(null, "BreadCrumb")

    Div({
        style {
        }
    }) {
        if (selectedChoices.isNotEmpty()) {
            A("#wine-selector", {
                title("Annuler")
                onClick {
                    logger.info("Removing last choice")
                    selectedChoices.removeLastOrNull()
                }
                classes("more-link")
            }) {
                Text("<<")
            }
        }
    }

}