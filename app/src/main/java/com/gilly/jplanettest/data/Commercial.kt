package com.gilly.jplanettest.data

import com.google.gson.annotations.SerializedName

/**
 * cell_type : CELL_TYPE_HORIZONTAL_THEME 인 경우
 */
data class Commercial(
    val count: Int,
    @SerializedName("themes") val themes: ArrayList<Theme> = arrayListOf(),
)