package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class AccessTokenModelTest: UnitTest() {
  companion object{
    const val TOKEN = "just_another_fake_email"
  }

  private lateinit var accessTokenModel: AccessTokenModel

  @Before
  fun setUp() {
    accessTokenModel = AccessTokenModel(TOKEN)
  }

  @Test
  fun `returns correct token when initialized`() {
    assertEquals(accessTokenModel.token, TOKEN)
  }
}
