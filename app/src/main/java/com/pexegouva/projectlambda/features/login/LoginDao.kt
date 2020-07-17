package com.pexegouva.projectlambda.features.login

import android.content.SharedPreferences
import arrow.core.Try
import com.pexegouva.projectlambda.features.authentication.AccessTokenEntity

class LoginDao(
  private val sessionTokenDb: SharedPreferences
) {
  companion object {
    const val CURRENT_USER_SESSION_TOKEN_KEY = "current_user_session_token"
  }

  fun storeSessionToken(accessTokenEntity: AccessTokenEntity): Try<Boolean> =
    Try {
      val dbEdit = sessionTokenDb.edit()
      dbEdit.putString(CURRENT_USER_SESSION_TOKEN_KEY, accessTokenEntity.token)

      dbEdit.commit()
    }

  fun findSessionToken(): Try<AccessTokenEntity> =
    Try {
      val sessionToken = sessionTokenDb.getString(CURRENT_USER_SESSION_TOKEN_KEY, "")
      AccessTokenEntity(sessionToken!!)
    }

  fun deleteSessionToken(): Try<Boolean> =
    Try {
      val dbEdit = sessionTokenDb.edit()
      dbEdit.remove(CURRENT_USER_SESSION_TOKEN_KEY)

      dbEdit.commit()
    }
}
