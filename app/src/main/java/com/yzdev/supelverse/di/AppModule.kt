package com.yzdev.supelverse.di

import com.yzdev.supelverse.common.Constants
import com.yzdev.supelverse.common.Constants.BASE_URL
import com.yzdev.supelverse.data.remote.InterceptorClient
import com.yzdev.supelverse.data.remote.SupelverseApi
import com.yzdev.supelverse.data.repository.BrawlStarsRepositoryImp
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
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
    fun provideBaseUrl() = Constants.BASE_URL

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(InterceptorClient())
    }.build()

    @Provides
    @Singleton
    fun provideSupelverseApi(@Named("BaseUrl") baseUrl: String): SupelverseApi{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SupelverseApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBrawlStarsRepository(api: SupelverseApi): BrawlStarsRepository{
        return BrawlStarsRepositoryImp(api)
    }
}