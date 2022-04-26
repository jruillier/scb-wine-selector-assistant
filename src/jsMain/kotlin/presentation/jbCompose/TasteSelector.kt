package presentation.jbCompose

import androidx.compose.runtime.*
import domain.vo.ChoiceVO
import domain.usecase.GetChoicesUC
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.dom.Div
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@Composable
fun ChoiceSelector(rootChoice: ChoiceVO?, onSelected: (choice: ChoiceVO) -> Unit) {

    val getChoicesUC: GetChoicesUC by localDI().instance()

    Div({
        style {
            display(DisplayStyle.Flex)
            flexWrap(FlexWrap.Wrap)
        }
    }) {
        getChoicesUC.exec(rootChoice).forEach {
            SelectorButton(it.label, it.imageSrc, onClick = {
                onSelected.invoke(it)
            })
        }
    }
}