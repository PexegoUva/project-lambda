package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LoginDataStoreFactoryTest: UnitTest() {
  private lateinit var networkRepository: ILoginRepository.Network
  private lateinit var dbRepository: ILoginRepository.Database
  private lateinit var loginDataStoreFactory: LoginDataStoreFactory

  @Mock private lateinit var service: LoginService
  @Mock private lateinit var loginDao: LoginDao

  @Before
  fun networkSetup() {
    networkRepository = ILoginRepository.Network(service)
    loginDataStoreFactory = LoginDataStoreFactory(service, loginDao)
  }

  @Test
  fun `should return Network`() {
    val result = loginDataStoreFactory.cloudBased()
    assertNotNull(result)
    assertEquals(result::class.java, networkRepository.javaClass)
  }

  @Before
  fun dbSetup() {
    dbRepository = ILoginRepository.Database(loginDao)
    loginDataStoreFactory = LoginDataStoreFactory(service, loginDao)
  }

  @Test
  fun `should return Database`() {
    val result = loginDataStoreFactory.dbBased()
    assertNotNull(result)
    assertEquals(result::class.java, dbRepository.javaClass)
  }
}
