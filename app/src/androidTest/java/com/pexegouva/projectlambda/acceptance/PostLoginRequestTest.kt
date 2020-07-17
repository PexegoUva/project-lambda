package com.pexegouva.projectlambda.acceptance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.pexegouva.projectlambda.AcceptanceTest
import com.pexegouva.projectlambda.R
import com.pexegouva.projectlambda.features.login.LoginActivity
import com.pexegouva.projectlambda.features.logout.LogoutActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class PostLoginRequestTest: AcceptanceTest<LoginActivity>(LoginActivity::class.java) {
  private val incorrectEmail = "another_incorrect_email"
  private val incorrectPassword = "another_incorrect_password"
  private val correctEmail = "pexegouva@leviathan.com"
  private val correctPassword = "chupliflascinoso"

  private lateinit var loginActivity: LoginActivity

  @Before
  fun setUp() {
    loginActivity = activityRule.activity
  }

  @Test
  fun whenIncorrectEmailOrPasswordErrorMessageIsShown() {
    givenIncorrectEmailAndPasswordSigninClick()
    checkToastIsShownWithErrorMessage()
  }

  @Test
  fun whenCorrectEmailAndPasswordNavigatesToLogoutView() {
    givenCorrectEmailAndPassword()

    Intents.init()
    onView(withId(R.id.loginScreenSigninButton)).perform(click())
    intended(hasComponent(LogoutActivity::class.java.name))
    Intents.release()
  }

  private fun givenCorrectEmailAndPassword() {
    onView(withId(R.id.loginScreenEmail)).perform(typeText(correctEmail), closeSoftKeyboard())
    onView(withId(R.id.loginScreenPassword)).perform(typeText(correctPassword), closeSoftKeyboard())

    onView(withId(R.id.loginScreenEmail)).check(matches(withText(correctEmail)))
    onView(withId(R.id.loginScreenPassword)).check(matches(withText(correctPassword)))
  }

  private fun givenIncorrectEmailAndPasswordSigninClick() {
    onView(withId(R.id.loginScreenEmail)).perform(typeText(incorrectEmail), closeSoftKeyboard())
    onView(withId(R.id.loginScreenPassword)).perform(typeText(incorrectPassword), closeSoftKeyboard())

    onView(withId(R.id.loginScreenEmail)).check(matches(withText(incorrectEmail)))
    onView(withId(R.id.loginScreenPassword)).check(matches(withText(incorrectPassword)))

    onView(withId(R.id.loginScreenSigninButton)).perform(click())
  }

  private fun checkToastIsShownWithErrorMessage() {
    onView(withText(R.string.failure_incorrect_email_or_password))
      .inRoot(withDecorView(not(loginActivity.window.decorView)))
      .check(matches(isDisplayed()))
  }
}
