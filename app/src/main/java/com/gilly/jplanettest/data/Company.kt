package com.gilly.jplanettest.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * cell_type : CELL_TYPE_COMPANY 인 경우
 */
data class Company(
    val ranking: Int,
    @SerializedName("interview_difficulty") val interviewDifficulty: Float,
    val name: String,
    @SerializedName("salary_avg") val salaryAvg: Long,
    @SerializedName("web_site") val webSiteUrl: String,
    @SerializedName("logo_path") val imgUrl: String,
    @SerializedName("interview_question") val interviewQuestion: String,
    @SerializedName("company_id") val companyId: Int,
    @SerializedName("has_job_posting") val hasJobPosting: String,
    @SerializedName("rate_total_avg") val rateTotalAvg: Float,
    @SerializedName("industry_id") val industryId: Int,
    @SerializedName("review_summary") val reviewSummary: String,
    @SerializedName("type") val type: String,
    @SerializedName("industry_name") val industryName: String,
    @SerializedName("simple_desc") val simpleDesc: String,
) : CellType(), Serializable