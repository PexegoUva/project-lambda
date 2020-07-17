package com.pexegouva.projectlambda.features.authentication

import arrow.core.Left
import arrow.core.Right
import com.pexegouva.projectlambda.AndroidTest
import com.pexegouva.projectlambda.features.login.LoginFailures
import org.junit.Before
import org.junit.Test
import org.koin.test.inject
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AuthenticationRepositoryTest: AndroidTest() {
  private lateinit var authenticationRepository: AuthenticationRepository
  private val authenticationDataStoreFactory: AuthenticationDataStoreFactory by inject()

  @Before
  fun cloudTest() {
    authenticationRepository =
      AuthenticationRepository(
        authenticationDataStoreFactory
      )
  }

  @Test
  fun `should return cloud data store`() {
    val result = authenticationRepository.login("fake_email", "fake_password")
    assertNotNull(result)
    assertEquals(result::class.java.name, Left(LoginFailures.IncorrectEmailOrPassword())::class.java.name)
  }

  @Test
  fun `should return db data store when storing token`() {
    val result = authenticationRepository.storeToken(
      AccessToken(
        "fake_token"
      )
    )
    assertNotNull(result)
    assertEquals(result::class.java.name, Right(true)::class.java.name)
  }

  @Test
  fun `should return db data store when getting token`() {
    val result = authenticationRepository.getAccessToken()
    assertNotNull(result)
    assertEquals(result::class.java.name, Right("")::class.java.name)
  }

  @Test
  fun `should return db data store when successful logout`() {
    val result = authenticationRepository.logout()
    assertNotNull(result)
    assertEquals(result::class.java.name, Right(true)::class.java.name)
  }
}
