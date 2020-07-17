package com.pexegouva.projectlambda.features.logout

import com.pexegouva.projectlambda.base.mvp.Presenter
import com.pexegouva.projectlambda.base.mvp.View

class LogoutPresenter(
  private val postLogout: PostLogout
): Presenter {
  private lateinit var view: LogoutView

  override fun start(view: View) {
    this.view = view as LogoutView
  }

  fun logoutUser() {
    postLogout.execute().fold(
      { view.handleError(it) },
      { handleLogoutSuccess() }
    )
  }

  private fun handleLogoutSuccess() {
    view.handleLogoutSuccess()
  }
}
