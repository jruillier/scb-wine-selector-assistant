package presentation.jbCompose

import androidx.compose.runtime.*
import domain.usecase.GetChoicesUC
import domain.vo.ChoiceVO
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@Composable
fun ChoiceSelector(rootChoice: ChoiceVO?, onSelected: (choice: ChoiceVO) -> Unit) {

    val getChoicesUC: GetChoicesUC by localDI().instance()
    var availableChoices: List<ChoiceVO> by remember { mutableStateOf(listOf()) }

    LaunchedEffect(key1 = rootChoice, block = {
        availableChoices = getChoicesUC.exec(rootChoice)
    })

    Div({
        style {
            display(DisplayStyle.Flex)
            flexWrap(FlexWrap.Wrap)
            justifyContent(JustifyContent.SpaceEvenly)
            gap(10.px)
        }
    }) {
        availableChoices.forEach {
            SelectorButton(it.label, it.imageSrc, onClick = {
                onSelected.invoke(it)
            })
        }
    }
}