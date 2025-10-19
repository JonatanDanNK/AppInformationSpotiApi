package com.openpay.spotityinfo.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.openpay.spotityinfo.data.model.ArtistItem
import com.openpay.spotityinfo.ui.viewmodel.ArtistsListViewModel

@Composable
fun ArtistScreen( viewModel: ArtistsListViewModel = hiltViewModel(),
                  onArtistClick: (String) -> Unit) {
    val artists by viewModel.artists.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.getArtists("pop")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
            .padding(8.dp)
    ) {
        Text(
            text = "Artistas Pop",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )  {
            items(artists) { artist ->
                ArtistCard(artist) {
                    onArtistClick(artist.id)
                }
            }
        }
    }
}

@Composable
fun ArtistCard(artist: ArtistItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = artist.images.firstOrNull()?.url,
                contentDescription = artist.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(artist.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                artist.genres.firstOrNull()?.let {
                    Text(it, fontSize = 14.sp, color = Color.Gray)
                }
            }
        }
    }
}
