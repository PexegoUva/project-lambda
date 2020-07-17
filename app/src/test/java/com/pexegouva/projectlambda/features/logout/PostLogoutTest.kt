package com.pexegouva.projectlambda.features.logout

import arrow.core.Right
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.login.LoginRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class PostLogoutTest: UnitTest() {
  private lateinit var postLogout: PostLogout

  @Mock private lateinit var loginRepository: LoginRepository

  @Before fun setUp() {
    postLogout = PostLogout(loginRepository)
    given {
      loginRepository.logout()
    }.willReturn(Right(true))
  }

  @Test fun `should get delete confirmation from repository`() {
    postLogout.execute()

    verify(loginRepository).logout()
    verifyNoMoreInteractions(loginRepository)
  }
}
