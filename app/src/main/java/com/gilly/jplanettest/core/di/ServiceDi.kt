package com.gilly.jplanettest.core.di

import com.gilly.jplanettest.domain.service.JPlanetService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class ServiceDi {

    @Provides
    @Singleton
    fun provideJPlanetService(retrofit: Retrofit): JPlanetService =
        retrofit.create(JPlanetService::class.java)

}