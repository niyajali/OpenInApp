package com.niyaj.openinapp.feature.dashboard.data.service

import com.niyaj.openinapp.feature.dashboard.domain.model.Dashboard
import com.niyaj.openinapp.feature.utils.Constants.DASHBOARD_URL
import retrofit2.http.GET

interface DashboardService {

    @GET(DASHBOARD_URL)
    suspend fun getDashboardData(): Dashboard
}