package com.pexegouva.projectlambda.features.authentication

class AuthenticationDataStoreFactory(
  private val service: AuthenticationService,
  private val authenticationDao: AuthenticationDao
) {
  fun dbBased(): IAuthenticationRepository.Database {
    return IAuthenticationRepository.Database(authenticationDao = authenticationDao)
  }

  fun cloudBased(): IAuthenticationRepository.Network {
    return IAuthenticationRepository.Network(service = service)
  }
}
