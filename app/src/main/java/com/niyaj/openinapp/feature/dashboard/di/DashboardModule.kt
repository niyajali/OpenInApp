package com.niyaj.openinapp.feature.dashboard.di

import com.niyaj.openinapp.feature.dashboard.data.repository.DashboardRepositoryImpl
import com.niyaj.openinapp.feature.dashboard.data.service.DashboardService
import com.niyaj.openinapp.feature.dashboard.domain.repository.DashboardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {

    @Provides
    fun provideDashboardRepository(dashboardService: DashboardService): DashboardRepository {
        return DashboardRepositoryImpl(dashboardService)
    }
}