package com.pexegouva.projectlambda.features.logout

import org.koin.core.qualifier.named
import org.koin.dsl.module

val logoutModule = module {
  scope(named<LogoutActivity>()) {
    factory { PostLogout(loginRepository = get()) }

    scoped { LogoutPresenter(postLogout = get()) }
  }
}
