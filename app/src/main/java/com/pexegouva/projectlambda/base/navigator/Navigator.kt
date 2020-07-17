package com.pexegouva.projectlambda.base.navigator

import android.content.Context
import com.pexegouva.projectlambda.features.authentication.Authentication
import com.pexegouva.projectlambda.features.login.LoginActivity
import com.pexegouva.projectlambda.features.logout.LogoutActivity

class Navigator(
  private val authenticator: Authentication
) {
  fun showLogin(context: Context) = context.startActivity(LoginActivity.callingIntent(context))

  fun showLogoutView(context: Context) {
    context.startActivity(LogoutActivity.callingIntent(context))
  }

  fun showHomeView(context: Context) {
    when (authenticator.userIsAuthenticated()) {
      true -> showLogoutView(context)
      false -> showLogin(context)
    }
  }
}
