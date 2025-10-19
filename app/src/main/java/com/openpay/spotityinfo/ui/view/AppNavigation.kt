package com.openpay.spotityinfo.ui.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "artists") {
        composable("artists") {
            ArtistScreen { artistId ->
                navController.navigate("albums/$artistId")
            }
        }

        composable(
            route = "albums/{artistId}",
            arguments = listOf(navArgument("artistId") { type = NavType.StringType })
        ) { backStackEntry ->
            val artistId = backStackEntry.arguments?.getString("artistId") ?: ""
            AlbumsScreen(
                artistId = artistId,
                onAlbumClick = { albumId ->
                    navController.navigate("tracks/$albumId")
                }
            )
        }

        composable(
            "tracks/{albumId}",
            arguments = listOf(navArgument("albumId") { type = NavType.StringType })
        ) { backStackEntry ->
            val albumId = backStackEntry.arguments?.getString("albumId") ?: ""
            TracksScreen(albumId)
        }
    }
}