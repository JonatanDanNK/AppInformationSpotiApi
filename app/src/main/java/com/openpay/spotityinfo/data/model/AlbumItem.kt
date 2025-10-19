package com.openpay.spotityinfo.data.model

data class AlbumItem(
    val id: String,
    val name: String,
    val images: List<Image>,
    val release_date: String
)
