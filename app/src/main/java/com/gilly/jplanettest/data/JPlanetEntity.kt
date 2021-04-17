package com.gilly.jplanettest.data

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

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
                    .filter { it.get(CELL_TYPE_KEY) == ECellTYPE.COMPANY.apiValue }
                    .map { Gson().fromJson(Gson().toJson(it), Company::class.java) })
        }

    /**
     * cell type = CELL_TYPE_HORIZONTAL_THEME 인 것만 뽑은 데이터
     */
    val commercials: ArrayList<Commercial>
        get() {
            return ArrayList(
                _items
                    .filter { it.get(CELL_TYPE_KEY) == ECellTYPE.COMMERCIAL.apiValue }
                    .map { Gson().fromJson(Gson().toJson(it), Commercial::class.java) })
        }

    /**
     * cell type = CELL_TYPE_REVIEW 인 것만 뽑은 데이터
     */
    val reviews: ArrayList<Review>
        get() {
            return ArrayList(
                _items
                    .filter { it.get(CELL_TYPE_KEY) == ECellTYPE.REVIEW.apiValue }
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
                        !(this == ECellTYPE.COMPANY.apiValue ||
                                this == ECellTYPE.COMMERCIAL.apiValue ||
                                this == ECellTYPE.REVIEW.apiValue)
                    }
                }
                .map {
                    when (it.get(CELL_TYPE_KEY)) {
                        ECellTYPE.COMPANY.apiValue -> {
                            Gson().fromJson(Gson().toJson(it), Company::class.java) as CellType
                        }
                        ECellTYPE.COMMERCIAL.apiValue -> {
                            Gson().fromJson(
                                Gson().toJson(it),
                                Commercial::class.java
                            ) as CellType
                        }
                        ECellTYPE.REVIEW.apiValue -> {
                            Gson().fromJson(Gson().toJson(it), Review::class.java) as CellType
                        }
                        else -> null
                    }
                })
        }

    enum class ECellTYPE(val apiValue: String) {
        COMPANY("CELL_TYPE_COMPANY"),
        COMMERCIAL("CELL_TYPE_HORIZONTAL_THEME"),
        REVIEW("CELL_TYPE_REVIEW")
    }

    companion object {
        private const val CELL_TYPE_KEY = "cell_type"
    }
}