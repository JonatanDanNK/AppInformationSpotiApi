package com.openpay.spotityinfo.data.di

import com.openpay.spotityinfo.data.network.ServicesConstants
import com.openpay.spotityinfo.data.network.SpotifyApi
import com.openpay.spotityinfo.data.network.SpotifyAutApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named("spotifyApi")
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ServicesConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideSpotifyApi(@Named("spotifyApi") retrofit: Retrofit): SpotifyApi =
        retrofit.create(SpotifyApi::class.java)

    @Provides
    @Singleton
    @Named("authApi")
    fun provideAuthRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ServicesConstants.BASE_ULR_AUTH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideSpotifyAuthApi(@Named("authApi")authRetrofit: Retrofit): SpotifyAutApi =
        authRetrofit.create(SpotifyAutApi::class.java)
}