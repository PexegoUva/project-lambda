package com.pexegouva.projectlambda.features.authentication

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AuthenticationDataStoreFactoryTest: UnitTest() {
  private lateinit var networkRepository: IAuthenticationRepository.Network
  private lateinit var dbRepository: IAuthenticationRepository.Database
  private lateinit var authenticationDataStoreFactory: AuthenticationDataStoreFactory

  @Mock private lateinit var service: AuthenticationService
  @Mock private lateinit var authenticationDao: AuthenticationDao

  @Before
  fun networkSetup() {
    networkRepository = IAuthenticationRepository.Network(service)
    authenticationDataStoreFactory =
      AuthenticationDataStoreFactory(
        service,
        authenticationDao
      )
  }

  @Test
  fun `should return Network`() {
    val result = authenticationDataStoreFactory.cloudBased()
    assertNotNull(result)
    assertEquals(result::class.java, networkRepository.javaClass)
  }

  @Before
  fun dbSetup() {
    dbRepository = IAuthenticationRepository.Database(authenticationDao)
    authenticationDataStoreFactory =
      AuthenticationDataStoreFactory(
        service,
        authenticationDao
      )
  }

  @Test
  fun `should return Database`() {
    val result = authenticationDataStoreFactory.dbBased()
    assertNotNull(result)
    assertEquals(result::class.java, dbRepository.javaClass)
  }
}
