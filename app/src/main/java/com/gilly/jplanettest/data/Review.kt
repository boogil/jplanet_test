package com.gilly.jplanettest.data

import com.google.gson.annotations.SerializedName

/**
 * cell_type : CELL_TYPE_REVIEW 인 경우
 */
data class Review(
    val ranking: Int,
    @SerializedName("cons") val cons: String,
    val name: String,
    @SerializedName("days_ago") val daysAgo: Long,
    @SerializedName("logo_path") val logoUrl: String,
    @SerializedName("pros") val pros: String,
    @SerializedName("company_id") val companyId: Int,
    @SerializedName("occupation_name") val occupationName: String,
    @SerializedName("rate_total_avg") val rateTotalAvg: Float,
    @SerializedName("industry_id") val industryId: Int,
    @SerializedName("date") val dateStr: String,
    @SerializedName("review_summary") val reviewSummary: String,
    @SerializedName("type") val type: String,
    @SerializedName("industry_name") val industryName: String,
    @SerializedName("simple_desc") val simpleDesc: String,
) : CellType()