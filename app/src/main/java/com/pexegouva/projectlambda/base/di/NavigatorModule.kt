package com.pexegouva.projectlambda.base.di

import com.pexegouva.projectlambda.base.navigator.Navigator
import org.koin.core.module.Module
import org.koin.dsl.module

val navigatorModule: Module = module {
  single {
    Navigator()
  }
}
