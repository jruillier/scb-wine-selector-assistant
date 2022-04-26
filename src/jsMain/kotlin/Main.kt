import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.renderComposable
import org.kodein.di.compose.withDI
import presentation.jbCompose.WineSelectorAssistant
import config.viewDI

fun main() {
    renderComposable(rootElementId = "root") {
        App()
    }
}

@Composable
fun App() = withDI(viewDI) {
    WineSelectorAssistant()
}

