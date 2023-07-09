package com.niyaj.openinapp.feature.dashboard.presentation

import com.niyaj.openinapp.feature.dashboard.domain.model.Dashboard

sealed interface DashboardUiState {

    object Loading: DashboardUiState

    data class Error(val message: String) : DashboardUiState

    data class Success(val data: Dashboard): DashboardUiState
}