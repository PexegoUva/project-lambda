package com.pexegouva.projectlambda.base.navigator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pexegouva.projectlambda.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
  private val navigator: Navigator by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setTheme(R.style.AppTheme_NoActionBar)

    navigator.showHomeView(this)
  }
}
