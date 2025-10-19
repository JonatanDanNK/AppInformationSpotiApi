package com.openpay.spotityinfo.data.repository

import com.openpay.spotityinfo.data.model.TracksResponse
import com.openpay.spotityinfo.data.network.SpotifyApi
import javax.inject.Inject

class TrackRepository @Inject constructor(private val api: SpotifyApi){

    suspend fun getTracks(token: String, trackId: String): TracksResponse {
        return api.getTracksByAlbum("Bearer $token", trackId)
    }
}