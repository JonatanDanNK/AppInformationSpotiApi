package com.openpay.spotityinfo.data.repository

import android.util.Base64
import android.util.Log
import com.openpay.spotityinfo.data.network.SpotifyAutApi
import javax.inject.Inject

class SpotifyAuthRepository @Inject constructor(
    private val api: SpotifyAutApi
) {
    suspend fun getAccessToken(clientId: String, clientSecret: String): String {
        val credentials = "$clientId:$clientSecret"
        val encoded = Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
        val header = "Basic $encoded"
        val response = api.getAccessToken(authorization = header)
        Log.d("SpotifyAuthRepository", "Access token: ${response.access_token}")

        return response.access_token
    }
}