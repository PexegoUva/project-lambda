package com.pexegouva.projectlambda.features.login

class LoginDataStoreFactory(
  private val service: LoginService,
  private val loginDao: LoginDao
) {
  fun dbBased(): ILoginRepository.Database {
    return ILoginRepository.Database(loginDao = loginDao)
  }

  fun cloudBased(): ILoginRepository.Network {
    return ILoginRepository.Network(service = service)
  }
}
