package logger.kotlinLogging

import domain.loggerPort.LoggerFactoryPort
import domain.loggerPort.LoggerPort
import mu.KotlinLogging

class LoggerFactoryKLImpl: LoggerFactoryPort {

    override fun getLogger(loggerName: String): LoggerPort {
        return LoggerKLImpl(KotlinLogging.logger(loggerName))
    }

}