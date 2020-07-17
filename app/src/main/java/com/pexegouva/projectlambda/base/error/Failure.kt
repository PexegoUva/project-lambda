package com.pexegouva.projectlambda.base.error

sealed class Failure {
  abstract class StandardError: Failure()
  class DbFailure: StandardError()
}

