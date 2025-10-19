package com.openpay.spotityinfo.data.network

import com.openpay.spotityinfo.data.model.AlbumResponse
import com.openpay.spotityinfo.data.model.ArtistResponse
import com.openpay.spotityinfo.data.model.TracksResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyApi {
    @GET(ServicesConstants.ARTISTS_SEARCH)
    suspend fun getArtistsList(
        @Header("Authorization") token: String,
        @Query("q") query: String,
        @Query("type") type: String = "artist",
        @Query("limit") limit: Int = 50
    ): ArtistResponse

    @GET(ServicesConstants.ALBUMS_ENDPOINT)
    suspend fun getArtistAlbums(
        @Header("Authorization") authorization: String,
        @Path("artist_id") artistId: String,
        @Query("limit") limit: Int = 20
    ): AlbumResponse
}