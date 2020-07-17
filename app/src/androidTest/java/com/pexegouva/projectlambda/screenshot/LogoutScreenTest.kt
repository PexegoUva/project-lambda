package com.pexegouva.projectlambda.screenshot

import android.app.Activity
import com.karumi.shot.ScreenshotTest
import com.pexegouva.projectlambda.ScreenTest
import com.pexegouva.projectlambda.features.logout.LogoutActivity
import org.junit.Test

class LogoutScreenTest: ScreenTest<LogoutActivity>(LogoutActivity::class.java), ScreenshotTest {
  @Test
  fun showCorrectLogoutActivityDefaultLayout() {
    val logoutActivity = startActivity() as Activity
    compareScreenshot(logoutActivity)
  }
}
