package presentation.compose

import androidx.compose.runtime.Composable
import domain.vo.ChoiceVO
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun BreadCrumb(selectedChoices: MutableList<ChoiceVO>) {
    Ul({
        style {
            padding(0.px)
            height(2.em)
        }
    }) {
        selectedChoices.forEachIndexed { index, choiceVO ->
            Li({
                style {
                    display(DisplayStyle.InlineBlock)
                    margin(5.px)
                }
            }) {
                if (index != 0) {
                    Text(">")
                }
                Button({
                    style {
                        marginLeft(5.px)
                        marginRight(5.px)
                    }
                    onClick {
                        selectedChoices.removeAll(
                            selectedChoices.subList(
                                index,
                                selectedChoices.size
                            )
                        )
                    }
                }) {
                    Text("X")
                }
                Text(choiceVO.label)
            }
        }
    }
}