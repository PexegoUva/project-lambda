package com.pexegouva.projectlambda.features.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.pexegouva.projectlambda.R
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.base.mvp.BaseActivity
import com.pexegouva.projectlambda.base.navigator.Navigator
import com.pexegouva.projectlambda.features.authentication.AccessTokenModel
import kotlinx.android.synthetic.main.login_layout.*
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.currentScope

class LoginActivity: BaseActivity(), LoginView {
  companion object {
    fun callingIntent(context: Context) = Intent(context, LoginActivity::class.java)
  }

  private val presenter: LoginPresenter by currentScope.inject()
  private val navigator: Navigator by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.login_layout)

    initialize()
  }

  private fun initialize() {
    presenter.start(this)

    initUI()
  }

  private fun initUI() {
    loginScreenSigninButton.setOnClickListener {
      onSigninButtonClick()
    }
  }

  private fun onSigninButtonClick() {
    val email = loginScreenEmail.text.toString()
    val password = loginScreenPassword.text.toString()
    presenter.signInUser(email, password)
  }

  override fun handleLoginSuccess(accessTokenModel: AccessTokenModel) {
    showMessage(accessTokenModel.token)
  }

  override fun showLogoutView() {
    navigator.showLogoutView(this)
  }

  override fun handleError(failure: Failure) {
    when (failure) {
      is LoginFailures.IncorrectEmailOrPassword -> {
        showError(getString(R.string.failure_incorrect_email_or_password))
      }
    }
  }
}
