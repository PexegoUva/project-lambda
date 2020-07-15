package com.pexegouva.projectlambda.base.di

import com.pexegouva.projectlambda.features.login.loginModule

val allModules =
  listOf(
    navigatorModule,

    // Activity modules
    loginModule,

    // Repository modules
    repositoryModule
  )
