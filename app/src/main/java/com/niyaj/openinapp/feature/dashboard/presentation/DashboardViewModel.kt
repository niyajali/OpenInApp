package com.niyaj.openinapp.feature.dashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niyaj.openinapp.feature.dashboard.domain.repository.DashboardRepository
import com.niyaj.openinapp.feature.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getDashboardDate()
    }


    private fun getDashboardDate() {
        viewModelScope.launch {
            dashboardRepository.getDashboardData().collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState.value =
                            DashboardUiState.Error(result.message ?: "Unable to get data")
                    }

                    is Resource.Success -> {
                        result.data?.let { data ->
                            _uiState.value = DashboardUiState.Success(data)
                        }
                    }
                }
            }
        }
    }
}