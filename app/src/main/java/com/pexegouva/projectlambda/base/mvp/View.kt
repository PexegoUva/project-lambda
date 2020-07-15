package com.pexegouva.projectlambda.base.mvp

import com.pexegouva.projectlambda.base.error.Failure

interface View {
  fun handleError(failure: Failure)
}
