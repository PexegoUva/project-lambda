package com.pexegouva.projectlambda.base.navigator

import com.pexegouva.projectlambda.AndroidTest
import com.pexegouva.projectlambda.features.login.LoginActivity
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric

class MainActivityTest: AndroidTest() {
  private lateinit var mainActivity: MainActivity

  @Before fun setup() {
    mainActivity = Robolectric.buildActivity(MainActivity::class.java).create().get()
  }

  @Test
  fun `should call showHomeView onCreate and go to loginActivity`() {
    navigatesTo(mainActivity, LoginActivity())
  }
}
