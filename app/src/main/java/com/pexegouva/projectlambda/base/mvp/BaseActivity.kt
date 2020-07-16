package com.pexegouva.projectlambda.base.mvp

import android.graphics.PorterDuff
import android.view.View
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.pexegouva.projectlambda.R

abstract class BaseActivity: AppCompatActivity() {
  protected fun showError(message: String) {
    val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    val toastLayout: View? = toast.view
    toastLayout?.background?.setColorFilter(
      resources.getColor(R.color.red, theme), PorterDuff.Mode.SRC_IN
    )

    val toastText = toastLayout!!.findViewById<View>(android.R.id.message) as TextView
    toastText.setTextColor(resources.getColor(R.color.white, theme));

    toast.show()
  }

  protected fun showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }
}
