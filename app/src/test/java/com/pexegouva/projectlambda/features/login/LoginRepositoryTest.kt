package com.pexegouva.projectlambda.features.login

import arrow.core.Left
import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import org.koin.test.inject
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LoginRepositoryTest: UnitTest() {
  private lateinit var loginRepository: LoginRepository
  private val loginDataStoreFactory: LoginDataStoreFactory by inject()

  @Before
  fun setUp() {
    loginRepository = LoginRepository(loginDataStoreFactory)
  }

  @Test
  fun `should return cloud data store`() {
    val result = loginRepository.login("fake_email", "fake_password")
    assertNotNull(result)
    assertEquals(result::class.java.name, Left(LoginFailures.IncorrectEmailOrPassword())::class.java.name)
  }
}
