package com.pexegouva.projectlambda.screenshot

import android.app.Activity
import com.karumi.shot.ScreenshotTest
import com.pexegouva.projectlambda.ScreenTest
import com.pexegouva.projectlambda.features.login.LoginActivity
import org.junit.Test

class LoginScreenTest: ScreenTest<LoginActivity>(LoginActivity::class.java), ScreenshotTest {
  @Test
  fun showCorrectLoginActivityDefaultLayout() {
    val loginActivity = startActivity() as Activity
    compareScreenshot(loginActivity)
  }
}
