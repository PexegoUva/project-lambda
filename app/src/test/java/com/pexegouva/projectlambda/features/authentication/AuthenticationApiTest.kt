package com.pexegouva.projectlambda.features.authentication

import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.login.LoginEndpointException
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class AuthenticationApiTest: UnitTest() {
  private val correctEmail = "pexegouva@leviathan.com"
  private val correctPassword = "chupliflascinoso"
  private val incorrectEmail = "just_another_fake_email"
  private val incorrectPassword = "just_another_fake_password"

  private lateinit var authenticationApi: AuthenticationApi

  @Before fun setUp() {
    authenticationApi =
      AuthenticationApi()
  }

  @Test fun `should return new accessToken when correct credentials`() {
    val result = authenticationApi.login(correctEmail, correctPassword)
    assertNotNull(result)
    assertEquals(result::class, AccessTokenEntity::class)
  }

  @Test
  fun `should throw IncorrectEmailOrPassword when incorrect credentials`() {
    assertFailsWith<LoginEndpointException.IncorrectEmailOrPasswordException> {
      authenticationApi.login(incorrectEmail, incorrectPassword)
    }
  }
}
