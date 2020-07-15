package com.pexegouva.projectlambda

import android.app.Application
import com.pexegouva.projectlambda.base.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProjectLambdaApplication: Application() {
  override fun onCreate() {
    super.onCreate()
    initDependencyInjection()
  }

  private fun initDependencyInjection() {
    startKoin {
      if (BuildConfig.DEBUG) androidLogger()
      androidContext(this@ProjectLambdaApplication)
      modules(allModules)
    }
  }
}
