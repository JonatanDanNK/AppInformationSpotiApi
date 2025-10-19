package com.openpay.spotityinfo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.openpay.spotityinfo.data.model.AlbumItem
import com.openpay.spotityinfo.data.model.ArtistItem
import com.openpay.spotityinfo.data.model.TrackItem
import com.openpay.spotityinfo.domain.GetArtistsAlbumsUseCase
import com.openpay.spotityinfo.domain.GetArtistsListUseCase
import com.openpay.spotityinfo.domain.GetSpotifyTokenUseCase
import com.openpay.spotityinfo.domain.GetTracksByAlbumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistsListViewModel @Inject constructor(
    private val getSpotiToken: GetSpotifyTokenUseCase,
    private val getArtistsList: GetArtistsListUseCase,
    private val getArtistsAlbums: GetArtistsAlbumsUseCase,
    private val getTrack: GetTracksByAlbumUseCase
) : ViewModel() {
    private val _artists = MutableLiveData<List<ArtistItem>>()
    val artists: LiveData<List<ArtistItem>> get() = _artists

    private val _alubums = MutableLiveData<List<AlbumItem>>()
    val albums: LiveData<List<AlbumItem>> get() = _alubums

    private val _tracks = MutableLiveData<List<TrackItem>>()
    val tracks: LiveData<List<TrackItem>> get() = _tracks



    private val clientId = "491563c9aca84db08f07bd162de1eec2"
    private val clientSecret = "61f8ae8d8a31477c9f555eda596eda19"

    fun getArtists(query: String) {
        viewModelScope.launch {
            try {
                val token = getSpotiToken(clientId, clientSecret)
                Log.d("SpotifyAuthViewModel", "Access Token: $token")
                val response = getArtistsList(token, query)
                _artists.value = response.artists.items
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAlbumsByArtists(artistId: String){
        viewModelScope.launch {
            try {
                val token = getSpotiToken(clientId, clientSecret)
                val responseAlbums = getArtistsAlbums(token, artistId)
                _alubums.value = responseAlbums.items
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getTrackByAlbum(trackId: String){
        viewModelScope.launch {
            try {
                val token = getSpotiToken(clientId, clientSecret)
                val responseTracks = getTrack(token, trackId)
                _tracks.value = responseTracks.items
            } catch (e: Exception) {

            }
        }
    }
}