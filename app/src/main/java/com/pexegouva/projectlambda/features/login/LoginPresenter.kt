package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.base.mvp.Presenter
import com.pexegouva.projectlambda.base.mvp.View

class LoginPresenter: Presenter {
  private lateinit var view: LoginView

  override fun start(view: View) {
    this.view = view as LoginView
  }

  fun signInUser(email: String, password: String) {
    val email = email
  }
}
