package com.pexegouva.projectlambda.features.login

import arrow.core.Right
import arrow.core.Try
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import java.lang.Exception
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DatabaseRepositoryTest: UnitTest() {
  private lateinit var loginDatabaseRepository: ILoginRepository.Database
  private lateinit var accessTokenEntity: AccessTokenEntity
  private lateinit var accessToken: AccessToken

  @Mock private lateinit var loginDao: LoginDao

  @Before fun setUp() {
    accessToken = AccessToken("fake_token")
    accessTokenEntity = AccessTokenEntity("fake_token")
    loginDatabaseRepository = ILoginRepository.Database(loginDao)
  }

  @Test fun `should get true in Right side of Either`() {
    given { loginDao.storeSessionToken(accessTokenEntity) }.willReturn(Try{ true })

    val result = loginDatabaseRepository.storeToken(accessToken)

    assertEquals(result, Right(true))
    verify(loginDao).storeSessionToken(accessTokenEntity)
  }

  @Test fun `should get error in the Left side of Either`() {
    given { loginDao.storeSessionToken(accessTokenEntity) }.willReturn(Try.raiseError(Exception()))

    val result = loginDatabaseRepository.storeToken(accessToken)

    assertTrue(result.isLeft())
    result.fold(
      { failure -> assertEquals(failure::class, LoginFailures.DbFailure::class) },
      { }
    )
  }

  @Test fun `should get AccessToken in Right side of Either for getAccessToken`() {
    given { loginDao.findSessionToken() }.willReturn(Try{ accessTokenEntity })

    val result = loginDatabaseRepository.getAccessToken()

    assertEquals(result, Right(accessToken))
    verify(loginDao).findSessionToken()
  }

  @Test fun `should get error in the Left side of Either for getAccessToken`() {
    given { loginDao.findSessionToken() }.willReturn(Try.raiseError(Exception()))

    val result = loginDatabaseRepository.getAccessToken()

    assertTrue(result.isLeft())
    result.fold(
      { failure -> assertEquals(failure::class, LoginFailures.DbFailure::class) },
      { }
    )
  }
}

