package com.pexegouva.projectlambda.features.authentication

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure

class AuthenticationRepository(private val authenticationDataStoreFactory: AuthenticationDataStoreFactory):
  IAuthenticationRepository {
  override fun login(email: String, password: String): Either<Failure, AccessToken> =
    authenticationDataStoreFactory.cloudBased().login(email, password)

  override fun logout(): Either<Failure, Boolean> =
    authenticationDataStoreFactory.cloudBased().logout().fold(
      { Either.left(it) },
      { removeAccessToken() }
    )

  override fun storeToken(accessToken: AccessToken): Either<Failure, Boolean> =
    authenticationDataStoreFactory.dbBased().storeToken(accessToken)

  override fun getAccessToken(): Either<Failure, AccessToken> =
    authenticationDataStoreFactory.dbBased().getAccessToken()

  private fun removeAccessToken(): Either<Failure, Boolean> =
    authenticationDataStoreFactory.dbBased().logout()
}
