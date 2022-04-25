package presentation.compose

import androidx.compose.runtime.*
import domain.vo.ChoiceVO
import domain.usecase.GetChoicesUC
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.dom.Div

@Composable
fun ChoiceSelector(rootChoice: ChoiceVO?, onSelected: (choice: ChoiceVO) -> Unit) {

    val getChoicesUC = GetChoicesUC();

//    val selectedTaste: ChoiceVO? by remember { mutableStateOf(null) }

    Div({
        style {
            display(DisplayStyle.Flex)
            flexWrap(FlexWrap.Wrap)
        }
    }) {
        getChoicesUC.exec(rootChoice).forEach {
            SelectorButton(it.label, it.imageSrc, onClick = {
                onSelected.invoke(it);
//                if (it.url != null) {
//                    window.location.href = it.url
//                }
            })
        }
    }
}