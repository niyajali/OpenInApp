package com.niyaj.openinapp.feature.common.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor(context: Context): Interceptor {

    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sessionManager.getAuthToken()?.let {  token ->
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        requestBuilder
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(requestBuilder.build())
    }
}