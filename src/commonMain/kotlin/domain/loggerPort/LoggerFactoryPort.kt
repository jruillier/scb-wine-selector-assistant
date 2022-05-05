package domain.loggerPort

import kotlin.reflect.KClass

interface LoggerFactoryPort {

    fun getLogger(loggerName: String): LoggerPort

    fun <T : Any> getLogger(loggerName: KClass<T>): LoggerPort

}