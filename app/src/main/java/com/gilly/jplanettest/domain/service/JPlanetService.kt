package com.gilly.jplanettest.domain.service

import com.gilly.jplanettest.data.JPlanetEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface JPlanetService {
    @GET("test_data.json")
    fun getData(): Single<JPlanetEntity>
}