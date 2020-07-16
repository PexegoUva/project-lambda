package com.pexegouva.projectlambda.features.login

import org.koin.core.qualifier.named
import org.koin.dsl.module

val loginModule = module {
  scope(named<LoginActivity>()) {
    factory { PostLogin(loginRepository = get()) }
    factory { StoreSessionToken(loginRepository = get()) }

    scoped { LoginPresenter(postLogin = get(), storeSessionToken = get()) }
  }
}
