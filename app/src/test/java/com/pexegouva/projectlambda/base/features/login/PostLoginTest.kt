package com.pexegouva.projectlambda.base.features.login

import arrow.core.Left
import arrow.core.Right
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.features.login.AccessToken
import com.pexegouva.projectlambda.features.login.LoginFailures
import com.pexegouva.projectlambda.features.login.LoginRepository
import com.pexegouva.projectlambda.features.login.PostLogin
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class PostLoginTest: UnitTest() {
  companion object{
    const val EMAIL = "just_another_fake_email"
    const val PASSWORD = "just_another_fake_password"
  }

  private lateinit var postLogin: PostLogin

  @Mock private lateinit var loginRepository: LoginRepository

  @Before fun setUp() {
    postLogin = PostLogin(loginRepository)
    given {
      loginRepository.login(EMAIL, PASSWORD)
    }.willReturn(Right(AccessToken("fake_session_token")))
  }

  @Test fun `should get data from repository`() {
    postLogin.execute(EMAIL, PASSWORD)

    verify(loginRepository).login(EMAIL, PASSWORD)
    verifyNoMoreInteractions(loginRepository)
  }
}
