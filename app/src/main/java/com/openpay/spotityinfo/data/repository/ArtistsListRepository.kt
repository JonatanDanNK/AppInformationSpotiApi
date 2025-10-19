package com.openpay.spotityinfo.data.repository

import com.openpay.spotityinfo.data.model.ArtistResponse
import com.openpay.spotityinfo.data.network.SpotifyApi
import javax.inject.Inject

class  ArtistsListRepository @Inject constructor(
    private val api: SpotifyApi
) {
    suspend fun artistsList(token: String, query: String): ArtistResponse {
        return api.getArtistsList("Bearer $token", query)
    }
}
