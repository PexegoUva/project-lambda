package com.pexegouva.projectlambda.base.extension

fun String.isEqual(otherString: String): Boolean {
  return this.compareTo(otherString) == 0
}
