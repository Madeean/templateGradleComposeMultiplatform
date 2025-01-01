package sharedFunction

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import presentation.test.TestViewModel

actual val viewModelModule = module {
  viewModelOf(::TestViewModel)
//  viewModelOf(::CharacterViewModel)
//  viewModelOf(::LocationViewModel)
  single { DatabaseFactory(androidApplication()) }
}