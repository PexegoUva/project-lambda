package com.pexegouva.projectlambda.features.authentication

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class AccessTokenEntityTest: UnitTest() {
  private val fakeToken = "just_another_fake_email"
  private val accessTokenClassName =
    "com.pexegouva.projectlambda.features.authentication.AccessToken"

  private lateinit var accessTokenEntity: AccessTokenEntity

  @Before
  fun setUp() {
    accessTokenEntity = AccessTokenEntity(fakeToken)
  }

  @Test
  fun `returns correct token when initialized`() {
    assertEquals(accessTokenEntity.token, fakeToken)
  }

  @Test
  fun `toAccessToken returns AccessToken`() {
    val accessToken = accessTokenEntity.toAccessToken()
    assertEquals(accessToken::class.java.name, accessTokenClassName)
  }
}
