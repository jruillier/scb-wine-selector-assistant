package config

import data.jsonSource.JsonDataRepositoryImpl
import domain.dataSourcePort.DataRepository
import domain.usecase.GetChoicesUC
import org.kodein.di.*

val viewDI = DI {
    bindSingleton { GetChoicesUC(instance()) }
    bindSingleton<DataRepository> { JsonDataRepositoryImpl() }
}
