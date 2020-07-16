package com.pexegouva.projectlambda.features.login

import arrow.core.Try
import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LoginServiceTest: UnitTest() {
  private lateinit var service: LoginService

  @Before
  fun setUp() {
    service = LoginService()
  }

  @Test
  fun `should return Try`() {
    val result = service.login("fake_email", "fake_password")
    assertNotNull(result)
    assertEquals(
      result::class.java.name,
      Try{throw LoginEndpointException.IncorrectEmailOrPasswordException()}::class.java.name
    )
  }
}
