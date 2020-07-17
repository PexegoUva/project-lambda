package com.pexegouva.projectlambda.features.login

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure

class LoginRepository(private val loginDataStoreFactory: LoginDataStoreFactory): ILoginRepository {
  override fun login(email: String, password: String): Either<Failure, AccessToken> =
    loginDataStoreFactory.cloudBased().login(email, password)

  override fun storeToken(accessToken: AccessToken): Either<Failure, Boolean> =
    loginDataStoreFactory.dbBased().storeToken(accessToken)

  override fun getAccessToken(): Either<Failure, AccessToken> =
    loginDataStoreFactory.dbBased().getAccessToken()
}
