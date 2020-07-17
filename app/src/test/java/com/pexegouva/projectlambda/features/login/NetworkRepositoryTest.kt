package com.pexegouva.projectlambda.features.login

import arrow.core.Right
import arrow.core.Try
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.features.authentication.AccessToken
import com.pexegouva.projectlambda.features.authentication.AccessTokenEntity
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NetworkRepositoryTest: UnitTest() {
  private val email = "pexegouva@leviathan.com"
  private val password = "chupliflascinoso"

  private lateinit var loginNetworkRepository: ILoginRepository.Network
  private lateinit var accessToken: AccessToken
  private lateinit var loginResponse: Try<AccessTokenEntity>

  @Mock private lateinit var service: LoginService
  @Mock private lateinit var accessTokenEntity: AccessTokenEntity

  @Before fun setUp() {
    loginNetworkRepository = ILoginRepository.Network(service)
  }

  @Test fun `should get correct accessToken in Right side of Either`() {
    loginResponse = Try{ accessTokenEntity }
    accessToken = AccessToken("fake_token")

    given { service.login(email, password) }.willReturn(loginResponse)
    given { accessTokenEntity.toAccessToken() }.willReturn(accessToken)

    val foundAccessToken =
      loginNetworkRepository.login(email, password)

    assertEquals(foundAccessToken, Right(accessToken))
    verify(service).login(email, password)
  }

  @Test fun `should get error in the Left side of Either`() {
    loginResponse = Try.raiseError(LoginEndpointException.IncorrectEmailOrPasswordException())

    given { service.login(email, password) }.willReturn(loginResponse)

    val result =
      loginNetworkRepository.login(email, password)

    assertTrue(result.isLeft())
    result.fold(
      { failure -> assertEquals(failure::class, LoginFailures.IncorrectEmailOrPassword::class) },
      { }
    )
  }

  @Test fun `should get true in the Right side of Either`() {
    val result = loginNetworkRepository.logout()
    assertTrue(result.isRight())
  }
}
