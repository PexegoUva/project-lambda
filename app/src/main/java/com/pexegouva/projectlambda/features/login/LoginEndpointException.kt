package com.pexegouva.projectlambda.features.login

import java.lang.Exception

sealed class LoginEndpointException {
  class IncorrectEmailOrPasswordException: Exception()
}
