package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.base.mvp.Presenter
import com.pexegouva.projectlambda.base.mvp.View
import com.pexegouva.projectlambda.features.authentication.AccessToken
import com.pexegouva.projectlambda.features.authentication.AccessTokenModel

class LoginPresenter(
  private val postLogin: PostLogin,
  private val storeSessionToken: StoreSessionToken
): Presenter {
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
    val accessTokenModel = AccessTokenModel(accessToken.token)
    view.handleLoginSuccess(accessTokenModel)

    storeSessionToken.execute(accessToken).fold(
      { view.handleError(it) },
      { view.showLogoutView() }
    )
  }
}
