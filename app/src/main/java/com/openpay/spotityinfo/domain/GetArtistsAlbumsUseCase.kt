package com.openpay.spotityinfo.domain

import com.openpay.spotityinfo.data.model.AlbumResponse
import com.openpay.spotityinfo.data.repository.ArtistsAlbumsRepository
import javax.inject.Inject

class GetArtistsAlbumsUseCase @Inject constructor(
    private val albumsRepository: ArtistsAlbumsRepository
){
    suspend operator fun invoke(token: String, artistId:String) =
        albumsRepository.getArtistAlbums(token, artistId)
}