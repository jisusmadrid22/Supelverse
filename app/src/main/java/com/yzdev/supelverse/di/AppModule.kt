package com.yzdev.supelverse.di

import com.yzdev.supelverse.common.Constants
import com.yzdev.supelverse.data.remote.*
import com.yzdev.supelverse.data.repository.BrawlStarsRepositoryImp
import com.yzdev.supelverse.data.repository.ClashOfClansRepositoryImp
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
import com.yzdev.supelverse.domain.repository.ClashOfClansRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrlBs() = Constants.BASE_URL_BS

    @Singleton
    @Provides
    @Named("BaseUrlCoc")
    fun provideBaseUrlCoc() = Constants.BASE_URL_COC

    @Singleton
    @Provides
    @Named("BaseUrlCr")
    fun provideBaseUrlCr() = Constants.BASE_URL_CR

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(InterceptorClient())
    }.build()

    private val clientCr = OkHttpClient.Builder().apply {
        addInterceptor(InterceptorClientCr())
    }.build()

    private val clientCoc = OkHttpClient.Builder().apply {
        addInterceptor(InterceptorClientCoc())
    }.build()

    @Provides
    @Singleton
    fun provideBrawlStarsApi(@Named("BaseUrl") baseUrl: String): BrawlStarsApi{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BrawlStarsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCocApi(@Named("BaseUrlCoc") baseUrl: String): ClashOfClansApi{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(clientCoc)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClashOfClansApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBrawlStarsRepository(api: BrawlStarsApi): BrawlStarsRepository{
        return BrawlStarsRepositoryImp(api)
    }

    @Provides
    @Singleton
    fun provideClashOfClansRepository(api: ClashOfClansApi): ClashOfClansRepository{
        return ClashOfClansRepositoryImp(api)
    }
}