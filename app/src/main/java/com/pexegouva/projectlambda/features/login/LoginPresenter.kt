package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.base.mvp.Presenter
import com.pexegouva.projectlambda.base.mvp.View

class LoginPresenter
  constructor(private val postLogin: PostLogin): Presenter {
  private lateinit var view: LoginView

  override fun start(view: View) {
    this.view = view as LoginView
  }

  fun signInUser(email: String, password: String) =
    postLogin.execute(email, password).fold(
      { view.handleError(it) },
      { handleLoginSuccess(it) }
    )

  private fun handleLoginSuccess(accessToken: AccessToken) {
    // Store access token
    view.handleLoginSuccess()
  }
}
