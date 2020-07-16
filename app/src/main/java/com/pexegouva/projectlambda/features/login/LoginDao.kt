package com.pexegouva.projectlambda.features.login

import android.content.SharedPreferences
import arrow.core.Try

class LoginDao(
  private val sessionTokenDb: SharedPreferences
) {
  fun storeSessionToken(accessTokenEntity: AccessTokenEntity): Try<Boolean> =
    Try {
      val dbEdit = sessionTokenDb.edit()
      dbEdit.putString("current_user_session_token", accessTokenEntity.token)

      dbEdit.commit()
    }
}
