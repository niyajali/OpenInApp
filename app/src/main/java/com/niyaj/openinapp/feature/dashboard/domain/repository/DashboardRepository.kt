package com.niyaj.openinapp.feature.dashboard.domain.repository

import com.niyaj.openinapp.feature.dashboard.domain.model.Dashboard
import com.niyaj.openinapp.feature.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {

    suspend fun getDashboardData(): Flow<Resource<Dashboard>>
}