package logger.kotlinLogging

import domain.loggerPort.LoggerPort
import mu.KLogger

class LoggerKLImpl(private val logger: KLogger) : LoggerPort {

    override fun debug(str: String) {
        this.logger.debug { str }
    }

    override fun info(str: String) {
        this.logger.info { str }
    }

    override fun warn(str: String) {
        this.logger.warn { str }
    }

    override fun error(str: String) {
        this.logger.error { str }
    }
}