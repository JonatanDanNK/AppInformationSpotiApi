package com.openpay.spotityinfo.data.model

data class ArtistItem(
    val genres: List<String>,
    val id: String,
    val images: List<Image>,
    val name: String
)
