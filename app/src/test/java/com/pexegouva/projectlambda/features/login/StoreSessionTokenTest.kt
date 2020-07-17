package com.pexegouva.projectlambda.features.login

import arrow.core.Right
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.authentication.AccessToken
import com.pexegouva.projectlambda.features.authentication.AuthenticationRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class StoreSessionTokenTest: UnitTest() {
  private lateinit var accessToken: AccessToken
  private lateinit var storeSessionToken: StoreSessionToken

  @Mock private lateinit var authenticationRepository: AuthenticationRepository

  @Before
  fun setUp() {
    storeSessionToken = StoreSessionToken(authenticationRepository)
    accessToken = AccessToken("fake_token")
    given {
      authenticationRepository.storeToken(accessToken)
    }.willReturn(Right(true))
  }

  @Test
  fun `should get data from repository`() {
    storeSessionToken.execute(accessToken)

    verify(authenticationRepository).storeToken(accessToken)
    verifyNoMoreInteractions(authenticationRepository)
  }
}
