package com.pexegouva.projectlambda.features.authentication

import arrow.core.Right
import arrow.core.Try
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.login.LoginEndpointException
import com.pexegouva.projectlambda.features.login.LoginFailures
import org.hamcrest.core.StringContains
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NetworkRepositoryTest: UnitTest() {
  private val email = "pexegouva@leviathan.com"
  private val password = "chupliflascinoso"

  private lateinit var authenticationNetworkRepository: IAuthenticationRepository.Network
  private lateinit var accessToken: AccessToken
  private lateinit var loginResponse: Try<AccessTokenEntity>

  @Mock private lateinit var service: AuthenticationService
  @Mock private lateinit var accessTokenEntity: AccessTokenEntity

  @Before fun setUp() {
    authenticationNetworkRepository = IAuthenticationRepository.Network(service)
  }

  @Test fun `should get correct accessToken in Right side of Either`() {
    loginResponse = Try{ accessTokenEntity }
    accessToken = AccessToken("fake_token")

    given { service.login(email, password) }.willReturn(loginResponse)
    given { accessTokenEntity.toAccessToken() }.willReturn(accessToken)

    val foundAccessToken =
      authenticationNetworkRepository.login(email, password)

    assertEquals(foundAccessToken, Right(accessToken))
    verify(service).login(email, password)
  }

  @Test fun `should get error in the Left side of Either`() {
    loginResponse = Try.raiseError(LoginEndpointException.IncorrectEmailOrPasswordException())

    given { service.login(email, password) }.willReturn(loginResponse)

    val result =
      authenticationNetworkRepository.login(email, password)

    assertTrue(result.isLeft())
    result.fold(
      { failure -> assertEquals(failure::class, LoginFailures.IncorrectEmailOrPassword::class) },
      { }
    )
  }

  @Test fun `should get true in the Right side of Either`() {
    val result = authenticationNetworkRepository.logout()
    assertTrue(result.isRight())
  }

  @Test fun `storeToken should get error operation not implemented`() {
    try {
      authenticationNetworkRepository.storeToken(AccessToken("fake_token"))
    } catch (e: NotImplementedError) {
      Assert.assertThat(e.message,
        StringContains("An operation is not implemented: Not yet implemented")
      )
    }
  }

  @Test fun `getAccessToken should get error operation not implemented`() {
    try {
      authenticationNetworkRepository.getAccessToken()
    } catch (e: NotImplementedError) {
      Assert.assertThat(e.message,
        StringContains("An operation is not implemented: Not yet implemented")
      )
    }
  }
}
