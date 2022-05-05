package domain.configProviderPort

interface ConfigProviderPort {

    fun getStringConfig(key: String): String?

}