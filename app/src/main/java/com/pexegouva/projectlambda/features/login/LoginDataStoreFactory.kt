package com.pexegouva.projectlambda.features.login

class LoginDataStoreFactory(
  private val service: LoginService
) {
  fun cloudBased(): ILoginRepository.Network {
    return ILoginRepository.Network(service = service)
  }
}
