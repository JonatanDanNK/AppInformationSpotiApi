package com.openpay.spotityinfo.domain

import com.openpay.spotityinfo.data.repository.SpotifyAuthRepository
import javax.inject.Inject

class GetSpotifyTokenUseCase @Inject constructor(
    private val repository: SpotifyAuthRepository
) {
    suspend operator fun invoke(clientId: String, clientSecret: String): String {
        return repository.getAccessToken(clientId, clientSecret)
    }
}