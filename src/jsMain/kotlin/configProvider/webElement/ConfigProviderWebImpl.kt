package configProvider.webElement

import domain.configProviderPort.ConfigProviderPort
import kotlinx.browser.document

class ConfigProviderWebImpl : ConfigProviderPort {

    lateinit var rootElementId: String

    override fun getStringConfig(key: String): String? {
        return document
            .getElementById(this.rootElementId)!!
            .getAttribute("data-$key")
    }
}