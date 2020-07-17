package com.pexegouva.projectlambda.features.authentication

import arrow.core.Left
import arrow.core.Right
import com.nhaarman.mockitokotlin2.whenever
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.base.error.Failure
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals

class AuthenticationTest: UnitTest() {
  private lateinit var authenticator: Authentication

  @Mock lateinit var authenticationRepository: AuthenticationRepository

  @Before
  fun setUp() {
    authenticator = Authentication(authenticationRepository)
  }

  @Test
  fun `should return false when Failure`() {
    whenever(authenticationRepository.getAccessToken()).thenReturn(Left(Failure.DbFailure()))
    assertEquals(authenticator.userIsAuthenticated(), false)
  }

  @Test
  fun `should return false when void token`() {
    whenever(authenticationRepository.getAccessToken()).thenReturn(Right(AccessToken("")))
    assertEquals(authenticator.userIsAuthenticated(), false)
  }

  @Test
  fun `should return true`() {
    whenever(authenticationRepository.getAccessToken()).thenReturn(Right(AccessToken("fake_token")))
    assertEquals(authenticator.userIsAuthenticated(), true)
  }
}
