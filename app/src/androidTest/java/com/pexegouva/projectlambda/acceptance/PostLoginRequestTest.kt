package com.pexegouva.projectlambda.acceptance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.pexegouva.projectlambda.AcceptanceTest
import com.pexegouva.projectlambda.R
import com.pexegouva.projectlambda.features.login.LoginActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class PostLoginRequestTest: AcceptanceTest<LoginActivity>(LoginActivity::class.java) {
  private lateinit var loginActivity: LoginActivity

  @Before
  fun setUp() {
    loginActivity = activityRule.activity
  }

  @Test
  fun when_incorrect_email_or_password_error_message_is_shown() {
    onView(withId(R.id.loginScreenEmail)).perform(typeText("hoygan"), closeSoftKeyboard())
    onView(withId(R.id.loginScreenPassword)).perform(typeText("password_hoygan"), closeSoftKeyboard())

    onView(withId(R.id.loginScreenEmail))
      .check(matches(withText("hoygan")))
    onView(withId(R.id.loginScreenPassword))
      .check(matches(withText("password_hoygan")))

    onView(withId(R.id.loginScreenSigninButton)).perform(click())

    onView(withText(R.string.failure_incorrect_email_or_password))
      .inRoot(withDecorView(not(loginActivity.window.decorView)))
      .check(matches(isDisplayed()))
  }
}
