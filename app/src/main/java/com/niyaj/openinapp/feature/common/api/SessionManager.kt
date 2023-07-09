package com.niyaj.openinapp.feature.common.api

import android.content.Context
import android.content.SharedPreferences
import com.niyaj.openinapp.R

class SessionManager(context: Context) {

    private var pref: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )

    companion object {
        const val BEARER_TOKEN = "bearer_token"
    }

    fun saveBearerToken(bearerToken: String) {
        val editor = pref.edit()
        editor.putString(BEARER_TOKEN, bearerToken)
        editor.apply()
    }

    fun getAuthToken(): String? {
        return pref.getString(BEARER_TOKEN, null)
    }
}