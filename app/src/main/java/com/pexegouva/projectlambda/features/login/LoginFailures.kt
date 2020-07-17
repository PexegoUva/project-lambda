package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.base.error.Failure

sealed class LoginFailures {
  class IncorrectEmailOrPassword: Failure.StandardError()
}
