package presentation.compose

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun SelectorButton(text: String, imageSrc: String, onClick: () -> Unit) {
    Div({
        style {
            flex(1, 0, 30.percent)

            border(1.px, LineStyle.Solid, Color.black)
            cursor("pointer")
            margin(5.px)
            padding(20.px)
            textAlign("center")

            backgroundImage("url('$imageSrc')")
            backgroundPosition("center")
            backgroundRepeat("no-repeat")
            backgroundSize("cover")
        }
        onClick {
            onClick.invoke()
        }
    }) {
        Text(text)
    }
}