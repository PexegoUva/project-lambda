package com.pexegouva.projectlambda.features.authentication

import arrow.core.Try
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.login.LoginEndpointException
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AuthenticationServiceTest: UnitTest() {
  private lateinit var service: AuthenticationService

  @Before
  fun setUp() {
    service =
      AuthenticationService()
  }

  @Test
  fun `should return Try`() {
    val result = service.login("fake_email", "fake_password")
    assertNotNull(result)
    assertEquals(
      result::class.java.name,
      Try{throw LoginEndpointException.IncorrectEmailOrPasswordException() }::class.java.name
    )
  }
}
