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

class PostLoginTest: UnitTest() {
  private val incorrectEmail = "just_another_fake_email"
  private val incorrectPassword = "just_another_fake_password"

  private lateinit var postLogin: PostLogin

  @Mock private lateinit var authenticationRepository: AuthenticationRepository

  @Before fun setUp() {
    postLogin = PostLogin(authenticationRepository)
    given {
      authenticationRepository.login(incorrectEmail, incorrectPassword)
    }.willReturn(Right(AccessToken("fake_session_token")))
  }

  @Test fun `should get data from repository`() {
    postLogin.execute(incorrectEmail, incorrectPassword)

    verify(authenticationRepository).login(incorrectEmail, incorrectPassword)
    verifyNoMoreInteractions(authenticationRepository)
  }
}
