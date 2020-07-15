package com.pexegouva.projectlambda

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.test.core.app.ApplicationProvider
import org.amshove.kluent.shouldBeEqualTo
import org.junit.After
import org.junit.Rule
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
abstract class AndroidTest {
  @Suppress("LeakingThis")
  @Rule @JvmField val injectMocks = InjectMocksRule.create(this@AndroidTest)

  fun context(): Context = ApplicationProvider.getApplicationContext()

  fun navigatesTo(originActivity: AppCompatActivity, destinationActivity: AppCompatActivity): String? {
    val shadowActivity = Shadows.shadowOf(originActivity)
    val nextIntent = shadowActivity.peekNextStartedActivity()

    return nextIntent.component?.className shouldBeEqualTo destinationActivity::class.java.canonicalName
  }

  @After
  fun tearDown() {
    stopKoin()
  }
}
