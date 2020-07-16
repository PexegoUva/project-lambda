package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class LoginApiTest: UnitTest() {
  private val correctEmail = "pexegouva@leviathan.com"
  private val correctPassword = "chupliflascinoso"
  private val incorrectEmail = "just_another_fake_email"
  private val incorrectPassword = "just_another_fake_password"

  private lateinit var loginApi: LoginApi

  @Before fun setUp() {
    loginApi = LoginApi()
  }

  @Test fun `should return new accessToken when correct credentials`() {
    val result = loginApi.login(correctEmail, correctPassword)
    assertNotNull(result)
    assertEquals(result::class, AccessTokenEntity::class)
  }

  @Test
  fun `should throw IncorrectEmailOrPassword when incorrect credentials`() {
    assertFailsWith<LoginEndpointException.IncorrectEmailOrPasswordException> {
      loginApi.login(incorrectEmail, incorrectPassword)
    }
  }
}
