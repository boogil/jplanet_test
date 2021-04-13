package com.gilly.jplanettest.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class JPlanetEntity(
    val minimum_interviews: Int,
    val total_page: Int,
    val minimum_reviews: Int,
    val total_count: Int,
    private val items: ArrayList<HashMap<String, String>> = arrayListOf(),
) {
    val companys: ArrayList<Company>
        get() {
            return ArrayList(
                items
                    .filter { it.get(CELL_TYPE_KEY) == CELL_TYPE.COMPANY.apiValue }
                    .map { Gson().fromJson(Gson().toJson(it), Company::class.java) })
        }

    val commercials: ArrayList<Commercial>
        get() {
            return ArrayList(
                items
                    .filter { it.get(CELL_TYPE_KEY) == CELL_TYPE.COMMERCIAL.apiValue }
                    .map { Gson().fromJson(Gson().toJson(it), Commercial::class.java) })
        }

    val reviews: ArrayList<Review>
        get() {
            return ArrayList(
                items
                    .filter { it.get(CELL_TYPE_KEY) == CELL_TYPE.REVIEW.apiValue }
                    .map { Gson().fromJson(Gson().toJson(it), Review::class.java) })
        }

    data class CellType(@SerializedName("cell_type") val cellType: String)

    enum class CELL_TYPE(val apiValue: String) {
        COMPANY("CELL_TYPE_COMPANY"),
        COMMERCIAL("CELL_TYPE_HORIZONTAL_THEME"),
        REVIEW("CELL_TYPE_REVIEW")
    }

    companion object {
        const val CELL_TYPE_KEY = "cell_type"
    }
}