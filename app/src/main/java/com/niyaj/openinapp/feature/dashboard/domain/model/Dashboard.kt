package com.niyaj.openinapp.feature.dashboard.domain.model


import com.google.gson.annotations.SerializedName

data class Dashboard(
    @SerializedName("applied_campaign")
    val appliedCampaign: Int = 0,

    @SerializedName("data")
    val data: Data = Data(),

    @SerializedName("extra_income")
    val extraIncome: Double = 0.0,

    @SerializedName("links_created_today")
    val linksCreatedToday: Int = 0,

    @SerializedName("message")
    val message: String = "",

    @SerializedName("startTime")
    val startTime: String = "",

    @SerializedName("status")
    val status: Boolean = false,

    @SerializedName("statusCode")
    val statusCode: Int = 0,

    @SerializedName("support_whatsapp_number")
    val supportWhatsappNumber: String = "",

    @SerializedName("today_clicks")
    val todayClicks: Int = 0,

    @SerializedName("top_location")
    val topLocation: String = "",

    @SerializedName("top_source")
    val topSource: String = "",

    @SerializedName("total_clicks")
    val totalClicks: Int = 0,

    @SerializedName("total_links")
    val totalLinks: Int = 0
)