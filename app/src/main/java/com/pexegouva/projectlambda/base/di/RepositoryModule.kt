package com.pexegouva.projectlambda.base.di

import com.pexegouva.projectlambda.features.login.LoginRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
  single {
    LoginRepository()
  }
}
