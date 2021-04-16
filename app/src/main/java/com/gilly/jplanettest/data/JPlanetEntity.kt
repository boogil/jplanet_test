package com.gilly.jplanettest.data

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.lang.Exception

data class JPlanetEntity(
    @SerializedName("minimum_interviews") val minimumInterviews: Int,
    @SerializedName("total_page") val totalPage: Int,
    @SerializedName("minimum_reviews") val minimumReviews: Int,
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("items") private val _items: ArrayList<HashMap<String, Any>> = arrayListOf(),
) {

    /**
     * cell type = CELL_TYPE_COMPANY 인 것만 뽑은 데이터
     */
    val companys: ArrayList<Company>
        get() {
            return ArrayList(
                _items
                    .filter { it.get(CELL_TYPE_KEY) == CELL_TYPE.COMPANY.apiValue }
                    .map { Gson().fromJson(Gson().toJson(it), Company::class.java) })
        }

    /**
     * cell type = CELL_TYPE_HORIZONTAL_THEME 인 것만 뽑은 데이터
     */
    val commercials: ArrayList<Commercial>
        get() {
            return ArrayList(
                _items
                    .filter { it.get(CELL_TYPE_KEY) == CELL_TYPE.COMMERCIAL.apiValue }
                    .map { Gson().fromJson(Gson().toJson(it), Commercial::class.java) })
        }

    /**
     * cell type = CELL_TYPE_REVIEW 인 것만 뽑은 데이터
     */
    val reviews: ArrayList<Review>
        get() {
            return ArrayList(
                _items
                    .filter { it.get(CELL_TYPE_KEY) == CELL_TYPE.REVIEW.apiValue }
                    .map { Gson().fromJson(Gson().toJson(it), Review::class.java) })
        }

    /**
     * cell type 클래스를 묶은 데이터
     */
    val cellTypes: ArrayList<CellType?>
        get() {
            return ArrayList(_items
                .filterNot { // 정의된 CELL_TYPE에 속하지 않은 것은 제외 시킴
                    with(it.get(CELL_TYPE_KEY)) {
                        this != CELL_TYPE.COMPANY.apiValue
                                && this != CELL_TYPE.COMMERCIAL.apiValue
                                && this != CELL_TYPE.REVIEW.apiValue
                    }
                }
                .map {
                    when (it.get(CELL_TYPE_KEY)) {
                        CELL_TYPE.COMPANY.apiValue -> {
                            Gson().fromJson(Gson().toJson(it), Company::class.java) as CellType
                        }
                        CELL_TYPE.COMMERCIAL.apiValue -> {
                            Gson().fromJson(Gson().toJson(it), Commercial::class.java) as CellType
                        }
                        CELL_TYPE.REVIEW.apiValue -> {
                            Gson().fromJson(Gson().toJson(it), Review::class.java) as CellType
                        }
                        else -> null
                    }
                })
        }


    enum class CELL_TYPE(val apiValue: String) {
        COMPANY("CELL_TYPE_COMPANY"),
        COMMERCIAL("CELL_TYPE_HORIZONTAL_THEME"),
        REVIEW("CELL_TYPE_REVIEW")
    }

    companion object {
        const val CELL_TYPE_KEY = "cell_type"
    }
}