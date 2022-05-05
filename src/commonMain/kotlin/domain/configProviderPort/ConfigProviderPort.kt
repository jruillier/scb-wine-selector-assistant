package domain.configProviderPort

interface ConfigProviderPort {

    fun getStringConfig(key: String): String?
    fun getBooleanConfig(key: String): Boolean

}