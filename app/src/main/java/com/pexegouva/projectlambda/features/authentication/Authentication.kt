package com.pexegouva.projectlambda.features.authentication

import com.pexegouva.projectlambda.features.login.AccessToken
import com.pexegouva.projectlambda.features.login.LoginRepository

class Authentication(
  private val loginRepository: LoginRepository
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
