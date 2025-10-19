package com.openpay.spotityinfo.domain

import com.openpay.spotityinfo.data.repository.TrackRepository
import javax.inject.Inject

class GetTracksByAlbumUseCase  @Inject constructor(private val trackRepository: TrackRepository) {

    suspend operator fun invoke(token: String, trackId:String) =
        trackRepository.getTracks(token, trackId)
}