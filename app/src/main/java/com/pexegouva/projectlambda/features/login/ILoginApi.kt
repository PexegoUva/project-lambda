package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.features.authentication.AccessTokenEntity

internal interface ILoginApi {
  fun login(email: String, password: String): AccessTokenEntity
}
