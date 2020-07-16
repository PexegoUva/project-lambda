package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class AccessTokenTest: UnitTest() {
  private val fakeToken = "just_another_fake_email"

  private lateinit var accessToken: AccessToken

  @Before
  fun setUp() {
    accessToken = AccessToken(fakeToken)
  }

  @Test
  fun `returns correct token when initialized`() {
    assertEquals(accessToken.token, fakeToken)
  }
}
