package com.gilly.jplanettest.data

import com.google.gson.annotations.SerializedName

data class Theme(
    val color: String,
    @SerializedName("cover_image") val coverImgUrl: String,
    val id: Int,
    val title: String
)