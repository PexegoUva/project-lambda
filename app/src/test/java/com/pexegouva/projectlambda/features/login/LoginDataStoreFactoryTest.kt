package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.UnitTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LoginDataStoreFactoryTest: UnitTest() {
  private lateinit var networkRepository: ILoginRepository.Network
  private lateinit var loginDataStoreFactory: LoginDataStoreFactory

  @Mock private lateinit var service: LoginService

  @Before
  fun setUp() {
    networkRepository = ILoginRepository.Network(service)
    loginDataStoreFactory = LoginDataStoreFactory(service)
  }

  @Test
  fun `should return Network`() {
    val result = loginDataStoreFactory.cloudBased()
    assertNotNull(result)
    assertEquals(result::class.java, networkRepository.javaClass)
  }
}
