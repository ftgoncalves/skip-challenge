package com.ftgoncalves.skip.skip.data.infra

import android.content.SharedPreferences
import javax.inject.Inject

open class UserPreference @Inject constructor(
    private val preferences: SharedPreferences
) {

  open fun saveToken(token: String) {
    preferences.edit()
        .putString(TOKEN, token)
        .apply()
  }

  fun getToken(): String = preferences.getString(TOKEN, "")

  fun isLogged() = preferences.contains(TOKEN)

  fun clear() {
    preferences.edit()
        .clear()
        .apply()
  }

  companion object {
    private const val TOKEN = "token"

  }
}
