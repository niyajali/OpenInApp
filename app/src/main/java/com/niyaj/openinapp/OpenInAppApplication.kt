package com.niyaj.openinapp

import android.app.Application
import com.niyaj.openinapp.feature.common.api.SessionManager
import com.niyaj.openinapp.feature.utils.Constants.TOKEN
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class OpenInAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        val sessionManager = SessionManager(this.applicationContext)

        val token = sessionManager.getAuthToken()

        if (token == null) {
            sessionManager.saveBearerToken(TOKEN)
        }
    }
}