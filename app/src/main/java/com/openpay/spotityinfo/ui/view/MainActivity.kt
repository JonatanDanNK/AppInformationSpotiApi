package com.openpay.spotityinfo.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
/*
    private val artistsListViewModel: ArtistsListViewModel by viewModels {
        object : androidx.lifecycle.ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return ArtistsListViewModel(GetArtistsListUseCase()) as T
            }
        }
    }

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TEST", "✅ onCreate se ejecutó correctamente")

        val token = "BQBbKixeSyhCFHxhzHiZpjTJTb0znlH2YP9H0vA_AKogRDugPp-Pg8dXe9bNzJAu4xVEEzAaFphlDhdPHpyYSxk086671k_wpsiX2tySAUuPc0BKTj1L5E9cJQhZRhkFryVWagj8hP8"

        lifecycleScope.launch {
            artistsListViewModel.getArtists(token, "pop")

            artistsListViewModel.artists.observe(this@MainActivity, Observer { artists ->
                artists.forEach {
                    Log.d("ARTISTS", "Lista: 🎵 ${it.name} → ${it.images.firstOrNull()?.url}")                    }
            })
        }

        setContent {
            SpotityInfoTheme {
                ArtistScreen()
            }
        }
    }
 */
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        AppNavigation() // ya no requiere factory manual
    }
}
}