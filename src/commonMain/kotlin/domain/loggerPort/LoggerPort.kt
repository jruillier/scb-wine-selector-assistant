package domain.loggerPort

interface LoggerPort {

    fun debug(str :String)
    fun info(str :String)
    fun warn(str :String)
    fun error(str :String)

}