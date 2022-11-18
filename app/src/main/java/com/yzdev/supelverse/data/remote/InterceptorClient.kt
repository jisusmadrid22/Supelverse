package com.yzdev.supelverse.data.remote

import com.yzdev.supelverse.common.Constants
import okhttp3.Interceptor
import okhttp3.Response

class InterceptorClient(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer ${Constants.TOKEN}")
            .build()
        return chain.proceed(request)
    }

}