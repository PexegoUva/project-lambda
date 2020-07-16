package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class AccessTokenEntityTest: UnitTest() {
  companion object{
    const val TOKEN = "just_another_fake_email"
    const val ACCESS_TOKEN_CLASS_NAME = "com.pexegouva.projectlambda.features.login.AccessToken"
  }

  private lateinit var accessTokenEntity: AccessTokenEntity

  @Before
  fun setUp() {
    accessTokenEntity = AccessTokenEntity(TOKEN)
  }

  @Test
  fun `returns correct token when initialized`() {
    assertEquals(accessTokenEntity.token, TOKEN)
  }

  @Test
  fun `toAccessToken returns AccessToken`() {
    val accessToken = accessTokenEntity.toAccessToken()
    assertEquals(accessToken::class.java.name, ACCESS_TOKEN_CLASS_NAME)
  }
}
