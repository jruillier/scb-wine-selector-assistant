import androidx.compose.runtime.Composable
import config.appDI
import configProvider.webElement.ConfigProviderWebImpl
import org.jetbrains.compose.web.renderComposable
import org.kodein.di.compose.withDI
import org.kodein.di.instance
import presentation.jbCompose.WineSelectorAssistant

fun main() {
    val configProvider by appDI.instance<ConfigProviderWebImpl>()
    configProvider.rootElementId = "wine-selector"
    renderComposable(rootElementId = configProvider.rootElementId) {
        App()
    }
}

@Composable
fun App() = withDI(appDI) {
    WineSelectorAssistant()
}

