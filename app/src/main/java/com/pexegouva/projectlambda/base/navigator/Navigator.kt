package com.pexegouva.projectlambda.base.navigator

import android.content.Context
import com.pexegouva.projectlambda.features.login.LoginActivity

class Navigator {
  private fun showLogin(context: Context) = context.startActivity(LoginActivity.callingIntent(context))

  fun showHomeView(context: Context) {
    showLogin(context)
  }
}
