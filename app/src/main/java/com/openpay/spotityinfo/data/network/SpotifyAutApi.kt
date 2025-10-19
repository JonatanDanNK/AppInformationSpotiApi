package com.openpay.spotityinfo.data.network

import com.openpay.spotityinfo.data.model.SpotifyAuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface SpotifyAutApi {

    @FormUrlEncoded
    @POST(ServicesConstants.AUT_API)
    suspend fun getAccessToken(
        @Header("Authorization") authorization: String,
        @Field("grant_type") grantType: String = "client_credentials"
    ): SpotifyAuthResponse
}