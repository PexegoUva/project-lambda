package com.pexegouva.projectlambda.base.di

import com.pexegouva.projectlambda.features.login.loginModule
import com.pexegouva.projectlambda.features.logout.logoutModule

val allModules =
  listOf(
    navigatorModule,

    // Activity modules
    loginModule,
    logoutModule,

    // Repository modules
    loginRepositoryModule
  )
