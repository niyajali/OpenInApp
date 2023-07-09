package com.niyaj.openinapp.feature.dashboard.data.repository

import com.niyaj.openinapp.feature.dashboard.data.service.DashboardService
import com.niyaj.openinapp.feature.dashboard.domain.model.Dashboard
import com.niyaj.openinapp.feature.dashboard.domain.repository.DashboardRepository
import com.niyaj.openinapp.feature.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

class DashboardRepositoryImpl(
    private val dashboardService: DashboardService
) : DashboardRepository {

    override suspend fun getDashboardData(): Flow<Resource<Dashboard>> {
        return channelFlow {
            try {
                val data = dashboardService.getDashboardData()

                send(Resource.Success(data))
            }catch (e: Exception) {
                send(Resource.Error(e.message))
            }
        }
    }
}