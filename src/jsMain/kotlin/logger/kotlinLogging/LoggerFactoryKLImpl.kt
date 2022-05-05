package logger.kotlinLogging

import domain.loggerPort.LoggerFactoryPort
import domain.loggerPort.LoggerPort
import mu.KotlinLogging
import kotlin.reflect.KClass

class LoggerFactoryKLImpl: LoggerFactoryPort {

    override fun getLogger(loggerName: String): LoggerPort {
        return LoggerKLImpl(KotlinLogging.logger(loggerName))
    }

    override fun <T : Any> getLogger(loggerName: KClass<T>): LoggerPort {
        return LoggerKLImpl(KotlinLogging.logger(loggerName.simpleName!!))
    }

}