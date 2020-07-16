package com.pexegouva.projectlambda.base.di

import android.content.Context
import com.pexegouva.projectlambda.features.login.LoginDao
import com.pexegouva.projectlambda.features.login.LoginDataStoreFactory
import com.pexegouva.projectlambda.features.login.LoginRepository
import com.pexegouva.projectlambda.features.login.LoginService
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val loginRepositoryModule: Module = module {
  single {
    LoginRepository(loginDataStoreFactory = get())
  }

  single {
    LoginDataStoreFactory(service = get(), loginDao = get())
  }

  single {
    LoginDao(sessionTokenDb = get())
  }

  single {
    LoginService()
  }

  single {
    androidContext().getSharedPreferences("session_token", Context.MODE_PRIVATE)
  }
}
