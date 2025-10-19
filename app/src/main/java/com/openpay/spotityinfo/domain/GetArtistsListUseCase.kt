package com.openpay.spotityinfo.domain

import com.openpay.spotityinfo.data.model.ArtistResponse
import com.openpay.spotityinfo.data.repository.ArtistsListRepository
import javax.inject.Inject

class GetArtistsListUseCase @Inject constructor(private val artistsListRepository: ArtistsListRepository) {

    suspend operator fun invoke(token: String, query: String) : ArtistResponse {
        return artistsListRepository.artistsList(token, query)
    }
}
