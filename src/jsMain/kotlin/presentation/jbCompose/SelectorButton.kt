package presentation.jbCompose

import androidx.compose.runtime.Composable
import domain.configProviderPort.ConfigProviderPort
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.kodein.di.compose.localDI
import org.kodein.di.instance
import org.w3c.dom.url.URL

private const val MAX_BTN_WIDTH_PX = 300

@Composable
fun SelectorButton(text: String, imageSrc: String?, onClick: () -> Unit) {

    val config: ConfigProviderPort by localDI().instance()
    val withImageResize = config.getBooleanConfig("image-resize")

    val imageUrl = if (imageSrc == null) null else URL(imageSrc, window.location.toString())

    val updatedImageSrc = updateImageWidthInUrl(imageUrl, withImageResize) ?: imageSrc

    Button({
        style {
            flex(1, 0, 30.percent)
            maxWidth(MAX_BTN_WIDTH_PX.px)
            height(100.px)
            if (updatedImageSrc != null) {
                backgroundImage("url('$updatedImageSrc')")
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
                if (updatedImageSrc != null) {
                    padding(10.px)
                    backgroundColor(rgba(0, 0, 0, 0.5))
                }
            }
        }) {
            Text(text)
        }
    }
}

private fun updateImageWidthInUrl(imageUrl: URL?, withImageResize: Boolean): String? {

    if (!withImageResize ||
        imageUrl?.pathname?.substringBeforeLast('.')?.endsWith('x') in listOf(null, true)) {
        return null
    }

    val origialPathname = imageUrl!!.pathname
    imageUrl.pathname = buildString {
        append(origialPathname.substringBeforeLast('.'))
        append("_${MAX_BTN_WIDTH_PX}x.")
        append(origialPathname.substringAfterLast('.'))
    }
    return imageUrl.toString()

}