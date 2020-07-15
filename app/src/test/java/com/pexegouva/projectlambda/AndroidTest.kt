package com.pexegouva.projectlambda

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
abstract class AndroidTest {
  fun context(): Context = ApplicationProvider.getApplicationContext()
}
