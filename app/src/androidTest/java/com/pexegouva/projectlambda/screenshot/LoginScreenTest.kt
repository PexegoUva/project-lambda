package com.pexegouva.projectlambda.screenshot

import android.app.Activity
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.filters.LargeTest
import com.karumi.shot.ScreenshotTest
import com.pexegouva.projectlambda.features.login.LoginActivity
import org.junit.Rule
import org.junit.Test

@LargeTest
class LoginScreenTest: ScreenshotTest {

  @get:Rule var activityRule: IntentsTestRule<LoginActivity> =
    IntentsTestRule(LoginActivity::class.java, true, false)

  @Test fun activityLayoutIsCorrect() {
    val mainActivity = startActivity() as Activity
    compareScreenshot(mainActivity);
  }

  private fun startActivity(): LoginActivity? {
    return activityRule.launchActivity(null)
  }
}
