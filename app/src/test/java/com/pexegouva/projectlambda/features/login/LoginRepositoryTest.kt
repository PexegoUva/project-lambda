package com.pexegouva.projectlambda.features.login

import arrow.core.Left
import arrow.core.Right
import com.pexegouva.projectlambda.AndroidTest
import com.pexegouva.projectlambda.features.authentication.AccessToken
import org.junit.Before
import org.junit.Test
import org.koin.test.inject
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LoginRepositoryTest: AndroidTest() {
  private lateinit var loginRepository: LoginRepository
  private val loginDataStoreFactory: LoginDataStoreFactory by inject()

  @Before
  fun cloudTest() {
    loginRepository = LoginRepository(loginDataStoreFactory)
  }

  @Test
  fun `should return cloud data store`() {
    val result = loginRepository.login("fake_email", "fake_password")
    assertNotNull(result)
    assertEquals(result::class.java.name, Left(LoginFailures.IncorrectEmailOrPassword())::class.java.name)
  }

  @Test
  fun `should return db data store when storing token`() {
    val result = loginRepository.storeToken(
      AccessToken(
        "fake_token"
      )
    )
    assertNotNull(result)
    assertEquals(result::class.java.name, Right(true)::class.java.name)
  }

  @Test
  fun `should return db data store when getting token`() {
    val result = loginRepository.getAccessToken()
    assertNotNull(result)
    assertEquals(result::class.java.name, Right("")::class.java.name)
  }

  @Test
  fun `should return db data store when successful logout`() {
    val result = loginRepository.logout()
    assertNotNull(result)
    assertEquals(result::class.java.name, Right(true)::class.java.name)
  }
}
