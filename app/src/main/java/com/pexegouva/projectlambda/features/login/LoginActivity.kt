package com.pexegouva.projectlambda.features.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.pexegouva.projectlambda.R
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.base.mvp.BaseActivity
import kotlinx.android.synthetic.main.login_layout.*
import org.koin.androidx.scope.currentScope

class LoginActivity: BaseActivity(), LoginView {
  companion object {
    fun callingIntent(context: Context) = Intent(context, LoginActivity::class.java)
  }

  private val presenter: LoginPresenter by currentScope.inject()

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

  override fun handleLoginSuccess() {
    TODO("Not yet implemented")
  }

  override fun handleError(failure: Failure) {
    when (failure) {
      is LoginFailures.IncorrectEmailOrPassword -> {
        showError(getString(R.string.failure_incorrect_email_or_password))
      }
    }
  }
}
