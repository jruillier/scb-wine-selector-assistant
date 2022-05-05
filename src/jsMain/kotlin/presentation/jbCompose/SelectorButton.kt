package presentation.jbCompose

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun SelectorButton(text: String, imageSrc: String?, onClick: () -> Unit) {
    Button({
        style {
            flex(1, 0, 30.percent)
            maxWidth(300.px)
            height(100.px)
            if (imageSrc != null) {
                backgroundImage("url('$imageSrc')")
                backgroundPosition("center")
                backgroundRepeat("no-repeat")
                backgroundSize("cover")
            }
        }
        classes("btn")
        onClick {
            onClick.invoke()
        }
    }) {
        Span({
            style {
                if (imageSrc != null) {
                    padding(10.px)
                    backgroundColor(rgba(0, 0, 0, 0.5))
                }
            }
        }){
            Text(text)
        }
    }
}