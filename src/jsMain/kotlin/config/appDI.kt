package config

import configProvider.webElement.ConfigProviderWebImpl
import data.jsonSource.JsonDataRepositoryImpl
import domain.configProviderPort.ConfigProviderPort
import domain.dataSourcePort.DataRepository
import domain.loggerPort.LoggerFactoryPort
import domain.usecase.GetChoicesUC
import logger.kotlinLogging.LoggerFactoryKLImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val appDI = DI {
    // Web config provider
    bindSingleton { ConfigProviderWebImpl() }
    bindSingleton<ConfigProviderPort> { instance<ConfigProviderWebImpl>() }

    // Domain
    bindSingleton { GetChoicesUC(instance(), instance()) }

    // Json Source Repository
    bindSingleton<DataRepository> { JsonDataRepositoryImpl(instance()) }

    // Logging
    bindSingleton<LoggerFactoryPort> { LoggerFactoryKLImpl() }
}
