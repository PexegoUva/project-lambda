package com.pexegouva.projectlambda.base.navigator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pexegouva.projectlambda.R

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setTheme(R.style.AppTheme_NoActionBar)
  }
}
