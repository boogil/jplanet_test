package com.gilly.jplanettest.core.di

import androidx.databinding.library.BuildConfig
import com.gilly.jplanettest.AndroidApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class RetrofitDi {
    class RetrofitModule {

        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://jpassets.jobplanet.co.kr/mobile-config/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun createClient(): OkHttpClient {
            val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                val loggingInterceptor =
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
                okHttpClientBuilder.addInterceptor(loggingInterceptor)
            }
            return okHttpClientBuilder.build()
        }
    }
}