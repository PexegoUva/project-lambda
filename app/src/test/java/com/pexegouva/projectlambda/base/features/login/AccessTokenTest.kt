package com.pexegouva.projectlambda.base.features.login

import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.login.AccessToken
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class AccessTokenTest: UnitTest() {
  companion object{
    const val TOKEN = "just_another_fake_email"
  }

  private lateinit var accessToken: AccessToken

  @Before
  fun setUp() {
    accessToken = AccessToken(TOKEN)
  }

  @Test
  fun `returns correct token when initialized`() {
    assertEquals(accessToken.token, TOKEN)
  }
}
