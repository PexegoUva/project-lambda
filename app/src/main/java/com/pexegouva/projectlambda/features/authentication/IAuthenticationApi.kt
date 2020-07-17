package com.pexegouva.projectlambda.features.authentication

import com.pexegouva.projectlambda.features.authentication.AccessTokenEntity

internal interface IAuthenticationApi {
  fun login(email: String, password: String): AccessTokenEntity
}
