package domain.loggerPort

interface LoggerFactoryPort {

    fun getLogger(loggerName: String): LoggerPort

}