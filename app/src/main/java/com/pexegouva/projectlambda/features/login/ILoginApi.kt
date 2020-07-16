package com.pexegouva.projectlambda.features.login

internal interface ILoginApi {
  fun login(email: String, password: String): AccessTokenEntity
}
