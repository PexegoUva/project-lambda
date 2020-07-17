package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.base.mvp.View
import com.pexegouva.projectlambda.features.authentication.AccessTokenModel

interface LoginView: View {
  fun handleLoginSuccess(accessTokenModel: AccessTokenModel)
  fun showLogoutView()
}
