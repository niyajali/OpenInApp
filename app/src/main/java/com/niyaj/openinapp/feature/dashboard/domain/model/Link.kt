package com.niyaj.openinapp.feature.dashboard.domain.model


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("app")
    val app: String = "",

    @SerializedName("created_at")
    val createdAt: String = "",

    @SerializedName("domain_id")
    val domainId: String = "",

    @SerializedName("original_image")
    val originalImage: String = "",

    @SerializedName("smart_link")
    val smartLink: String = "",

    @SerializedName("thumbnail")
    val thumbnail: String? = null,

    @SerializedName("times_ago")
    val timesAgo: String = "",

    @SerializedName("title")
    val title: String = "",

    @SerializedName("total_clicks")
    val totalClicks: Int = 0,

    @SerializedName("url_id")
    val urlId: Int = 0,

    @SerializedName("url_prefix")
    val urlPrefix: String? = null,

    @SerializedName("url_suffix")
    val urlSuffix: String = "",

    @SerializedName("web_link")
    val webLink: String = ""
)