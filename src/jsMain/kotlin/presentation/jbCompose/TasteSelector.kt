package presentation.jbCompose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import domain.usecase.GetChoicesUC
import domain.vo.ChoiceVO
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
    val availableChoices: MutableList<ChoiceVO> = mutableStateListOf()

    LaunchedEffect(key1 = rootChoice, block = {
        availableChoices.clear()
        availableChoices.addAll(getChoicesUC.exec(rootChoice))
    })

    Div({
        style {
            display(DisplayStyle.Flex)
            flexWrap(FlexWrap.Wrap)
        }
    }) {
        availableChoices.forEach {
            SelectorButton(it.label, it.imageSrc, onClick = {
                onSelected.invoke(it)
            })
        }
    }
}