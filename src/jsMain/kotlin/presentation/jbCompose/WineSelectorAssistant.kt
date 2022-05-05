package presentation.jbCompose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import domain.configProviderPort.ConfigProviderPort
import domain.vo.ChoiceVO
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@Composable
fun WineSelectorAssistant() {

    val configProvider: ConfigProviderPort by localDI().instance()
    val selectedChoices: MutableList<ChoiceVO> = mutableStateListOf()

    Div({
        style {
        }
    }) {

        Div({
            classes("opposing-items")
        }) {
            H1({ classes("section-heading", "left") }) {
                configProvider.getStringConfig("title")?.let {
                    Text(it)
                }
            }
            BreadCrumb(selectedChoices)
        }

        ChoiceSelector(selectedChoices.lastOrNull(), onSelected = { selectedChoice ->
            if (selectedChoice.targetHref != null) {
                window.location.href = selectedChoice.targetHref
                return@ChoiceSelector
            }
            selectedChoices.add(selectedChoice)
        })

    }

}
