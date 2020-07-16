package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class LoginApiTest: UnitTest() {
  companion object{
    const val CORRECT_EMAIL = "pexegouva@leviathan.com"
    const val CORRECT_PASSWORD = "chupliflascinoso"
    const val INCORRECT_EMAIL = "just_another_fake_email"
    const val INCORRECT_PASSWORD = "just_another_fake_password"
  }

  private lateinit var loginApi: LoginApi

  @Before fun setUp() {
    loginApi = LoginApi()
  }

  @Test fun `should return new accessToken when correct credentials`() {
    val result = loginApi.login(CORRECT_EMAIL, CORRECT_PASSWORD)
    assertNotNull(result)
    assertEquals(result::class, AccessTokenEntity::class)
  }

  @Test
  fun `should throw IncorrectEmailOrPassword when incorrect credentials`() {
    assertFailsWith<LoginEndpointException.IncorrectEmailOrPasswordException> {
      loginApi.login(INCORRECT_EMAIL, INCORRECT_PASSWORD)
    }
  }
}
