package com.pexegouva.projectlambda.features.logout

import arrow.core.Right
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.authentication.AuthenticationRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class PostLogoutTest: UnitTest() {
  private lateinit var postLogout: PostLogout

  @Mock private lateinit var authenticationRepository: AuthenticationRepository

  @Before fun setUp() {
    postLogout = PostLogout(authenticationRepository)
    given {
      authenticationRepository.logout()
    }.willReturn(Right(true))
  }

  @Test fun `should get delete confirmation from repository`() {
    postLogout.execute()

    verify(authenticationRepository).logout()
    verifyNoMoreInteractions(authenticationRepository)
  }
}
