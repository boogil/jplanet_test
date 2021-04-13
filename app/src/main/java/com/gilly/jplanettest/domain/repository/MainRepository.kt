package com.gilly.jplanettest.domain.repository

import com.gilly.jplanettest.data.JPlanetEntity
import com.gilly.jplanettest.domain.service.JPlanetService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val jPlanetService: JPlanetService
){
    fun getData(): Single<JPlanetEntity> = jPlanetService.getData()

}