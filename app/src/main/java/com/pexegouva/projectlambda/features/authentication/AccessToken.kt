package com.pexegouva.projectlambda.features.authentication

data class AccessToken(
  val token: String
) {
  fun toAccessTokenEntity() =
    AccessTokenEntity(token)
}
