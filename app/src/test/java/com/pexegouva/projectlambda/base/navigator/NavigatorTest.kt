package com.pexegouva.projectlambda.base.navigator

import androidx.appcompat.app.AppCompatActivity
import com.pexegouva.projectlambda.AndroidTest
import com.pexegouva.projectlambda.features.login.LoginActivity
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric

class NavigatorTest: AndroidTest() {
  private lateinit var navigator: Navigator
  private lateinit var originActivity: AppCompatActivity

  @Before fun setup() {
    navigator = Navigator()
    originActivity = Robolectric.buildActivity(MainActivity::class.java).get()
  }

  @Test fun `should take user to login screen`() {
    navigator.showHomeView(originActivity)

    navigatesTo(originActivity, LoginActivity())
  }
}
