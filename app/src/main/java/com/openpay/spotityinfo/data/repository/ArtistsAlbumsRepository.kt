package com.openpay.spotityinfo.data.repository

import com.openpay.spotityinfo.data.model.AlbumResponse
import com.openpay.spotityinfo.data.network.SpotifyApi
import javax.inject.Inject

class ArtistsAlbumsRepository  @Inject constructor(
    private val api: SpotifyApi) {

    suspend fun getArtistAlbums(token: String, artistId: String): AlbumResponse {
        return api.getArtistAlbums("Bearer $token", artistId)
    }
}