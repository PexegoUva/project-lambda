package com.pexegouva.projectlambda.features.login

import arrow.core.Right
import arrow.core.Try
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.pexegouva.projectlambda.UnitTest
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
  private lateinit var response: Try<AccessTokenEntity>

  @Mock private lateinit var service: LoginService
  @Mock private lateinit var accessTokenEntity: AccessTokenEntity

  @Before fun setUp() {
    loginNetworkRepository = ILoginRepository.Network(service)
  }

  @Test fun `should get correct accessToken in Right side of Either`() {
    response = Try{ accessTokenEntity }
    accessToken = AccessToken("fake_token")

    given { service.login(email, password) }.willReturn(response)
    given { accessTokenEntity.toAccessToken() }.willReturn(accessToken)

    val foundAccessToken =
      loginNetworkRepository.login(email, password)

    assertEquals(foundAccessToken, Right(accessToken))
    verify(service).login(email, password)
  }

  @Test fun `should get error in the Left side of Either`() {
    response = Try.raiseError(LoginEndpointException.IncorrectEmailOrPasswordException())

    given { service.login(email, password) }.willReturn(response)

    val result =
      loginNetworkRepository.login(email, password)

    assertTrue(result.isLeft())
    result.fold(
      { failure -> assertEquals(failure::class, LoginFailures.IncorrectEmailOrPassword::class) },
      { }
    )
  }
}
