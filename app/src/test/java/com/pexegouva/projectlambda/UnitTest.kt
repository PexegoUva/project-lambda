package com.pexegouva.projectlambda

import com.pexegouva.projectlambda.base.di.allModules
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
abstract class UnitTest: KoinTest {
  companion object {
    @BeforeClass
    @JvmStatic
    fun beforeTesting() {
      startKoin { modules(allModules) }
    }

    @AfterClass
    @JvmStatic
    fun afterTesting() {
      stopKoin()
    }
  }
}
