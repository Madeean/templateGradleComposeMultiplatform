package sharedFunction

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import presentation.test.TestViewModel

actual val viewModelModule = module {
  singleOf(::TestViewModel)
//  singleOf(::CharacterViewModel)
//  singleOf(::LocationViewModel)
  single { DatabaseFactory() }
}