package com.pexegouva.projectlambda.base.navigator

import android.content.Context
import com.pexegouva.projectlambda.features.login.LoginActivity
import com.pexegouva.projectlambda.features.logout.LogoutActivity

class Navigator {
  private fun showLogin(context: Context) = context.startActivity(LoginActivity.callingIntent(context))

  fun showHomeView(context: Context) {
    showLogin(context)
  }

  fun showLogoutView(context: Context) {
    context.startActivity(LogoutActivity.callingIntent(context))
  }
}
