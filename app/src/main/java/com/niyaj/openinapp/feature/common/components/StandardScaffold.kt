package com.niyaj.openinapp.feature.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.niyaj.openinapp.feature.common.ui.theme.SpaceLarge
import com.niyaj.openinapp.feature.common.ui.theme.SpaceMedium
import com.niyaj.openinapp.feature.common.ui.theme.containerColor
import com.niyaj.openinapp.feature.common.ui.theme.primaryColor
import com.niyaj.openinapp.feature.common.ui.theme.surfaceColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    title: String,
    @DrawableRes
    navIcon: Int,
    onNavClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()


    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                actions = {
                    FilledTonalIconButton(
                        onClick = onNavClick,
                        shape = RoundedCornerShape(SpaceMedium),
                        colors = IconButtonDefaults.filledTonalIconButtonColors(
                            containerColor = Color.White.copy(alpha = 0.12f)
                        ),
                        modifier = Modifier
                            .size(40.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = navIcon),
                            contentDescription = title + "Nav Icon",
                            tint = containerColor
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryColor,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        containerColor = primaryColor,
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = SpaceMedium),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 2.dp
            ),
            shape = RoundedCornerShape(SpaceLarge, SpaceLarge),
            colors = CardDefaults.elevatedCardColors(
                containerColor = surfaceColor,
            )
        ) {
            content()
        }
    }
}