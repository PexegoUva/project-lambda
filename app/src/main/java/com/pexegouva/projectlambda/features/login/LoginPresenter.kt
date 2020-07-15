package com.pexegouva.projectlambda.features.login

import android.view.View
import com.pexegouva.projectlambda.base.mvp.Presenter

class LoginPresenter: Presenter {
  private lateinit var view: LoginView

  override fun start(view: View) {
    this.view = view as LoginView
  }


}
