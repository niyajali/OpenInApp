package com.niyaj.openinapp.feature.dashboard.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.niyaj.openinapp.R
import com.niyaj.openinapp.feature.common.ui.theme.secondaryTextColor
import com.niyaj.openinapp.feature.utils.Extension.getGreetingHour

@Composable
fun Greeting(
    username: String,
    greetingText: String = getGreetingHour(),
    @DrawableRes
    iconRes: Int = R.drawable.hi
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = greetingText,
            style = MaterialTheme.typography.bodyLarge,
            color = secondaryTextColor,
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = username,
                style = MaterialTheme.typography.headlineSmall,
                lineHeight = 1.33.em,
                color = Color.Black,
            )

            Image(
                painter = painterResource(id = iconRes),
                contentDescription = username,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}