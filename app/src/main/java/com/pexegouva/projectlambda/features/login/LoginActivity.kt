package com.pexegouva.projectlambda.features.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pexegouva.projectlambda.R

class LoginActivity: AppCompatActivity(), LoginView {
  companion object {
    fun callingIntent(context: Context) = Intent(context, LoginActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.login_layout)
  }

  override fun handleLoginSuccess() {
    TODO("Not yet implemented")
  }

  override fun handleError() {
    TODO("Not yet implemented")
  }
}
