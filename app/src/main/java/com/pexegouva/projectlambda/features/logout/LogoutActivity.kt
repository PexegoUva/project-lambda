package com.pexegouva.projectlambda.features.logout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.pexegouva.projectlambda.R
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.base.mvp.BaseActivity
import com.pexegouva.projectlambda.base.navigator.Navigator
import kotlinx.android.synthetic.main.logout_layout.*
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.currentScope

class LogoutActivity: BaseActivity(), LogoutView {
  companion object {
    fun callingIntent(context: Context) = Intent(context, LogoutActivity::class.java)
  }

  private val presenter: LogoutPresenter by currentScope.inject()
  private val navigator: Navigator by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.logout_layout)

    initialize()
  }

  private fun initialize() {
    presenter.start(this)

    initUI()
  }

  private fun initUI() {
    logoutScreenLogoutButton.setOnClickListener {
      onLogoutButtonClick()
    }
  }

  private fun onLogoutButtonClick() {
    presenter.logoutUser()
  }

  override fun handleLogoutSuccess() {
    navigator.showLogin(this)
  }

  override fun handleError(failure: Failure) {
    when (failure) {
      is Failure.DbFailure -> {
        showError(getString(R.string.failure_db))
      }
    }
  }
}
