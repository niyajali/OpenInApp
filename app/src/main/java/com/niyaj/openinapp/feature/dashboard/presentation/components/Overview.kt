package com.niyaj.openinapp.feature.dashboard.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.niyaj.openinapp.R
import com.niyaj.openinapp.feature.common.ui.theme.SpaceLarge
import com.niyaj.openinapp.feature.common.ui.theme.SpaceMedium
import com.niyaj.openinapp.feature.common.ui.theme.SpaceMediumMax
import com.niyaj.openinapp.feature.common.ui.theme.SpaceSmall
import com.niyaj.openinapp.feature.common.ui.theme.SpaceSmallMax
import com.niyaj.openinapp.feature.common.ui.theme.containerColor
import com.niyaj.openinapp.feature.common.ui.theme.outlineColor
import com.niyaj.openinapp.feature.common.ui.theme.secondaryTextColor
import com.niyaj.openinapp.feature.dashboard.domain.utils.DashboardScreenTags.overview

@Composable
fun Overview(
    modifier: Modifier = Modifier,
    data: Map<String, Int>,
    title: String = overview
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(SpaceMedium),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = SpaceMediumMax, vertical = SpaceLarge),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall,
                    lineHeight = 1.43.em,
                    color = secondaryTextColor,
                )

                DateSelectionBox(
                    startDate = "20 sep",
                    endDate = "28 oct",
                    onClickDate = {}
                )
            }
        }


    }
}


@Composable
fun DateSelectionBox(
    modifier: Modifier = Modifier,
    startDate: String,
    endDate: String,
    @DrawableRes
    iconRes: Int = R.drawable.time,
    onClickDate: () -> Unit = {},
) {
    if (startDate.isNotEmpty() && endDate.isNotEmpty()) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(
                    BorderStroke(1.dp, outlineColor),
                    RoundedCornerShape(SpaceSmallMax)
                )
                .clip(RoundedCornerShape(SpaceSmallMax))
                .clickable {
                    onClickDate()
                }
                .padding(
                    start = SpaceMedium,
                    end = SpaceSmall,
                    top = SpaceSmallMax,
                    bottom = SpaceSmallMax
                )
        ) {
            Text(
                text = "$startDate - $endDate",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Black,
            )

            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "Clock Icon",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}