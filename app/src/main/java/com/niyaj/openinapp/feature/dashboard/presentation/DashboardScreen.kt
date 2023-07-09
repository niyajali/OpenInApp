package com.niyaj.openinapp.feature.dashboard.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.niyaj.openinapp.R
import com.niyaj.openinapp.feature.common.components.ErrorMessage
import com.niyaj.openinapp.feature.common.components.LoadingIndicator
import com.niyaj.openinapp.feature.common.components.StandardScaffold
import com.niyaj.openinapp.feature.common.ui.theme.SpaceExtraLarge
import com.niyaj.openinapp.feature.common.ui.theme.SpaceLarge
import com.niyaj.openinapp.feature.common.ui.theme.SpaceLargeMax
import com.niyaj.openinapp.feature.dashboard.domain.utils.DashboardScreenTags.title
import com.niyaj.openinapp.feature.dashboard.presentation.components.Greeting
import com.niyaj.openinapp.feature.dashboard.presentation.components.Overview

@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: DashboardViewModel = hiltViewModel(),
) {

    val lazyListState = rememberLazyListState()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    StandardScaffold(
        navController = navController,
        title = title,
        navIcon = R.drawable.settings,
    ) {
        Crossfade(
            targetState = uiState,
            label = "dashboardState"
        ) { state ->
            when(state) {
                is DashboardUiState.Loading -> LoadingIndicator()
                is DashboardUiState.Error -> {
                    ErrorMessage(errorMessage = state.message)
                }
                is DashboardUiState.Success -> {
                    val dashboard = state.data

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = SpaceExtraLarge, start = SpaceLarge, end = SpaceLarge),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(SpaceLargeMax),
                        state = lazyListState
                    ){
                        item("Greetings") {
                            Greeting(username = "Sk Niyaj Ali")
                        }

                        item("Overview") {
                            Overview(data = dashboard.data.overallUrlChart)
                        }
                    }
                }
            }
        }
    }
}