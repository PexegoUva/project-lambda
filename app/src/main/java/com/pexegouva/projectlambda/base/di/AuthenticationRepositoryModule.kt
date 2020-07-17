package com.pexegouva.projectlambda.base.di

import android.content.Context
import com.pexegouva.projectlambda.features.authentication.AuthenticationDao
import com.pexegouva.projectlambda.features.authentication.AuthenticationDataStoreFactory
import com.pexegouva.projectlambda.features.authentication.AuthenticationRepository
import com.pexegouva.projectlambda.features.authentication.AuthenticationService
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val authenticationRepositoryModule: Module = module {
  single {
    AuthenticationRepository(
      authenticationDataStoreFactory = get()
    )
  }

  single {
    AuthenticationDataStoreFactory(
      service = get(),
      authenticationDao = get()
    )
  }

  single {
    AuthenticationDao(
      sessionTokenDb = get()
    )
  }

  single {
    AuthenticationService()
  }

  single {
    androidContext().getSharedPreferences("session_token", Context.MODE_PRIVATE)
  }
}
