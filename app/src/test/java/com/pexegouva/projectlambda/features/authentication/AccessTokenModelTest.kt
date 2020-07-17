package com.pexegouva.projectlambda.features.authentication

import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.authentication.AccessTokenModel
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class AccessTokenModelTest: UnitTest() {
  private val fakeToken = "just_another_fake_email"

  private lateinit var accessTokenModel: AccessTokenModel

  @Before
  fun setUp() {
    accessTokenModel = AccessTokenModel(fakeToken)
  }

  @Test
  fun `returns correct token when initialized`() {
    assertEquals(accessTokenModel.token, fakeToken)
  }
}
