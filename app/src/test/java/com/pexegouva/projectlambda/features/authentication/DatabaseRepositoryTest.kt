package com.pexegouva.projectlambda.features.authentication

import arrow.core.Right
import arrow.core.Try
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.pexegouva.projectlambda.UnitTest
import com.pexegouva.projectlambda.base.error.Failure
import org.hamcrest.core.StringContains
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import java.lang.Exception
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DatabaseRepositoryTest: UnitTest() {
  private lateinit var authenticationDatabaseRepository: IAuthenticationRepository.Database
  private lateinit var accessTokenEntity: AccessTokenEntity
  private lateinit var accessToken: AccessToken

  @Mock private lateinit var authenticationDao: AuthenticationDao

  @Before fun setUp() {
    accessToken = AccessToken("fake_token")
    accessTokenEntity = AccessTokenEntity("fake_token")
    authenticationDatabaseRepository = IAuthenticationRepository.Database(authenticationDao)
  }

  @Test fun `should get true in Right side of Either`() {
    given { authenticationDao.storeSessionToken(accessTokenEntity) }.willReturn(Try{ true })

    val result = authenticationDatabaseRepository.storeToken(accessToken)

    assertEquals(result, Right(true))
    verify(authenticationDao).storeSessionToken(accessTokenEntity)
  }

  @Test fun `should get error in the Left side of Either`() {
    given { authenticationDao.storeSessionToken(accessTokenEntity) }.willReturn(Try.raiseError(Exception()))

    val result = authenticationDatabaseRepository.storeToken(accessToken)

    assertTrue(result.isLeft())
    result.fold(
      { failure -> assertEquals(failure::class, Failure.DbFailure::class) },
      { }
    )
  }

  @Test fun `should get AccessToken in Right side of Either for getAccessToken`() {
    given { authenticationDao.findSessionToken() }.willReturn(Try{ accessTokenEntity })

    val result = authenticationDatabaseRepository.getAccessToken()

    assertEquals(result, Right(accessToken))
    verify(authenticationDao).findSessionToken()
  }

  @Test fun `should get error in the Left side of Either for getAccessToken`() {
    given { authenticationDao.findSessionToken() }.willReturn(Try.raiseError(Exception()))

    val result = authenticationDatabaseRepository.getAccessToken()

    assertTrue(result.isLeft())
    result.fold(
      { failure -> assertEquals(failure::class, Failure.DbFailure::class) },
      { }
    )
  }

  @Test fun `should get True in Right side of Either for deleteSessionToken`() {
    given { authenticationDao.deleteSessionToken() }.willReturn(Try{ true })

    val result = authenticationDatabaseRepository.logout()

    assertEquals(result, Right(true))
    verify(authenticationDao).deleteSessionToken()
  }

  @Test fun `should get error in the Left side of Either for deleteSessionToken`() {
    given { authenticationDao.deleteSessionToken() }.willReturn(Try.raiseError(Exception()))

    val result = authenticationDatabaseRepository.logout()

    assertTrue(result.isLeft())
    result.fold(
      { failure -> assertEquals(failure::class, Failure.DbFailure::class) },
      { }
    )
  }

  @Test fun `should get error operation not implemented`() {
    try {
      authenticationDatabaseRepository.login("fake_email", "fake_password")
    } catch (e: NotImplementedError) {
      Assert.assertThat(e.message,
        StringContains("An operation is not implemented: Not yet implemented")
      )
    }
  }
}

