package com.pexegouva.projectlambda.acceptance

import android.content.Context
import android.content.SharedPreferences
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.pexegouva.projectlambda.AcceptanceTest
import com.pexegouva.projectlambda.R
import com.pexegouva.projectlambda.features.login.LoginActivity
import com.pexegouva.projectlambda.features.logout.LogoutActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PostLogoutRequestTest: AcceptanceTest<LogoutActivity>(LogoutActivity::class.java) {
  private lateinit var logoutActivity: LogoutActivity
  private lateinit var db: SharedPreferences

  @Before
  fun setUp() {
    logoutActivity = activityRule.activity
    db = context().getSharedPreferences("session_token", Context.MODE_PRIVATE)
  }

  @Test
  fun whenCorrectLogoutRequest() {
    Intents.init()
    givenExistingSessionTokenAndUserClicksOnLogoutButton()

    Intents.intended(IntentMatchers.hasComponent(LoginActivity::class.java.name))
    Intents.release()

    val sessionToken = db.getString("current_user_session_token", "")
    Assert.assertEquals(sessionToken, "")
  }

  private fun givenExistingSessionTokenAndUserClicksOnLogoutButton() {
    val editDB = db.edit()
    editDB.putString("current_user_session_token", "chupliflascino_token")
    editDB.apply()

    onView(withId(R.id.logoutScreenLogoutButton)).perform(click())
  }
}
