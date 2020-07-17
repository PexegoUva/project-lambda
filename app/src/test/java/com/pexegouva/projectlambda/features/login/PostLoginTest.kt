package com.pexegouva.projectlambda.features.login

import arrow.core.Right
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.authentication.AccessToken
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class PostLoginTest: UnitTest() {
  private val incorrectEmail = "just_another_fake_email"
  private val incorrectPassword = "just_another_fake_password"

  private lateinit var postLogin: PostLogin

  @Mock private lateinit var loginRepository: LoginRepository

  @Before fun setUp() {
    postLogin = PostLogin(loginRepository)
    given {
      loginRepository.login(incorrectEmail, incorrectPassword)
    }.willReturn(Right(AccessToken("fake_session_token")))
  }

  @Test fun `should get data from repository`() {
    postLogin.execute(incorrectEmail, incorrectPassword)

    verify(loginRepository).login(incorrectEmail, incorrectPassword)
    verifyNoMoreInteractions(loginRepository)
  }
}
