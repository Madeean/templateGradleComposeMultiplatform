package di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.local.AppDatabase
import data.repositoryImpl.transaction.RepositoryImpl
import domain.transaction.Repository
import domain.transaction.UseCase
import domain.transaction.UseCaseImpl
import org.koin.dsl.module
import presentation.test.TestViewModel
import sharedFunction.DatabaseFactory

val appModule = module {
  single { get<DatabaseFactory>().create().setDriver(BundledSQLiteDriver()).build() }
  single { get<AppDatabase>().transactionDao }

  //  LOCATION REPOSITORY
  single { RepositoryImpl(get()) }
  single { UseCaseImpl(get()) }
  single<UseCase> { UseCaseImpl(get()) }
  single<Repository> { RepositoryImpl(get()) }

  factory { TestViewModel(get()) }
}