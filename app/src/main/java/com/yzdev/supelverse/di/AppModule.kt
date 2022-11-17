package com.yzdev.supelverse.di

import com.yzdev.supelverse.data.remote.SupelverseApi
import com.yzdev.supelverse.data.repository.BrawlStarsRepositoryImp
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSupelverseApi(baseUrl: String): SupelverseApi{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
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