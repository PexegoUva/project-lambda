package com.pexegouva.projectlambda.base.navigator

import androidx.appcompat.app.AppCompatActivity
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.pexegouva.projectlambda.AndroidTest
import com.pexegouva.projectlambda.features.authentication.Authentication
import com.pexegouva.projectlambda.features.login.LoginActivity
import com.pexegouva.projectlambda.features.logout.LogoutActivity
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.robolectric.Robolectric

class NavigatorTest: AndroidTest() {
  private lateinit var navigator: Navigator
  private lateinit var originActivity: AppCompatActivity

  @Mock private lateinit var authenticator: Authentication

  @Before fun setUp() {
    navigator = Navigator(authenticator)
    originActivity = Robolectric.buildActivity(MainActivity::class.java).get()
    originActivity = Robolectric.buildActivity(LoginActivity::class.java).get()
  }

  @Test fun `should take user to login screen on entering the app`() {
    whenever(authenticator.userIsAuthenticated()).thenReturn(false)
    navigator.showHomeView(originActivity)

    navigatesTo(originActivity, LoginActivity())
  }

  @Test fun `should take user to logout screen on entering the app`() {
    whenever(authenticator.userIsAuthenticated()).thenReturn(true)
    navigator.showHomeView(originActivity)

    verify(authenticator).userIsAuthenticated()
    navigatesTo(originActivity, LogoutActivity())
  }

  @Test fun `should take user to logout screen`() {
    navigator.showLogoutView(originActivity)

    navigatesTo(originActivity, LogoutActivity())
  }

  @Test fun `should take user to login screen`() {
    navigator.showLogin(originActivity)

    navigatesTo(originActivity, LoginActivity())
  }
}
