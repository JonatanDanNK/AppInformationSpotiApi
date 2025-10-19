package com.openpay.spotityinfo.data.model

data class Artists(
    val href: String,
    val items: List<ArtistItem>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: Any,
    val total: Int
)