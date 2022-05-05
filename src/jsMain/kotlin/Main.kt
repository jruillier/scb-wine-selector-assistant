import androidx.compose.runtime.Composable
import config.viewDI
import org.jetbrains.compose.web.renderComposable
import org.kodein.di.compose.withDI
import presentation.jbCompose.WineSelectorAssistant

fun main() {
    renderComposable(rootElementId = "wine-selector") {
        App()
    }
}

@Composable
fun App() = withDI(viewDI) {
    WineSelectorAssistant()
}

