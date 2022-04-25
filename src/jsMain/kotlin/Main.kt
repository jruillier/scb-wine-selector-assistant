import org.jetbrains.compose.web.renderComposable
import presentation.compose.WineSelectorAssistant

fun main() {

    renderComposable(rootElementId = "root") {
        WineSelectorAssistant()
    }
}

