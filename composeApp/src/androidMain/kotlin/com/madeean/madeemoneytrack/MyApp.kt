package com.madeean.madeemoneytrack

import android.app.Application
import sharedFunction.KoinInitializer

class MyApp : Application() {

  override fun onCreate() {
    super.onCreate()
    KoinInitializer(applicationContext).init()
  }
}