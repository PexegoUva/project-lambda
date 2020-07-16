package com.pexegouva.projectlambda.features.logout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.pexegouva.projectlambda.R
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.base.mvp.BaseActivity

class LogoutActivity: BaseActivity(), LogoutView {
  companion object {
    fun callingIntent(context: Context) = Intent(context, LogoutActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.logout_layout)
  }

  override fun handleError(failure: Failure) {
    TODO("Not yet implemented")
  }
}
