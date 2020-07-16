package com.pexegouva.projectlambda.base.extension

import com.pexegouva.projectlambda.UnitTest
import org.junit.Test
import kotlin.test.assertEquals

class StringExtensionTest: UnitTest() {
  @Test fun `should return true when both strings are equal`() {
    val comparison = "just_another_fake_string".isEqual("just_another_fake_string")
    assertEquals(comparison, true)
  }

  @Test fun `should return false when strings are not equal`() {
    val comparison = "supercalifragilisticoespialidoso".isEqual("super")
    assertEquals(comparison, false)
  }
}
