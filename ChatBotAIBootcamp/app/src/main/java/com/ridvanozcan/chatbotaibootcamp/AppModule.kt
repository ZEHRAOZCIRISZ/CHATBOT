package com.ridvanozcan.chatbotaibootcamp

import com.ridvanozcan.chatbotaibootcamp.Constants.Companion.API_KEY
import com.ridvanozcan.chatbotaibootcamp.Constants.Companion.BASE_URL
import com.ridvanozcan.chatbotaibootcamp.model.di.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOkClient(): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor{ chain->
            val request = chain.request().newBuilder()
                .header( "Authorization" , "Bearer $API_KEY ")
                .build()
            chain.proceed(request)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }

}