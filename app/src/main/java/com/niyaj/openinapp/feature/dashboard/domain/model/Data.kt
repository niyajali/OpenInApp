package com.niyaj.openinapp.feature.dashboard.domain.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("recent_links")
    val recentLinks: List<Link> = listOf(),

    @SerializedName("top_links")
    val topLinks: List<Link> = listOf(),

    @SerializedName("overall_url_chart")
    val overallUrlChart: Map<String, Int> = emptyMap()
)