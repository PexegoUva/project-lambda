package com.pexegouva.projectlambda.features.authentication

class Authentication(
  private val loginRepository: AuthenticationRepository
) {
  fun userIsAuthenticated(): Boolean {
    var tokenExists = false
    loginRepository.getAccessToken().fold(
      { },
      { tokenExists = sessionTokenExists(it) }
    )

    return tokenExists
  }

  private fun sessionTokenExists(accessToken: AccessToken): Boolean = accessToken.token != ""
}
