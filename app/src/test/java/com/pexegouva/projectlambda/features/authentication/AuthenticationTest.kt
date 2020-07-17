package com.pexegouva.projectlambda.features.authentication

import arrow.core.Left
import arrow.core.Right
import com.nhaarman.mockitokotlin2.whenever
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.features.login.LoginRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals

class AuthenticationTest: UnitTest() {
  private lateinit var authenticator: Authentication

  @Mock lateinit var loginRepository: LoginRepository

  @Before
  fun setUp() {
    authenticator = Authentication(loginRepository)
  }

  @Test
  fun `should return false when Failure`() {
    whenever(loginRepository.getAccessToken()).thenReturn(Left(Failure.DbFailure()))
    assertEquals(authenticator.userIsAuthenticated(), false)
  }

  @Test
  fun `should return false when void token`() {
    whenever(loginRepository.getAccessToken()).thenReturn(Right(AccessToken("")))
    assertEquals(authenticator.userIsAuthenticated(), false)
  }

  @Test
  fun `should return true`() {
    whenever(loginRepository.getAccessToken()).thenReturn(Right(AccessToken("fake_token")))
    assertEquals(authenticator.userIsAuthenticated(), true)
  }
}
