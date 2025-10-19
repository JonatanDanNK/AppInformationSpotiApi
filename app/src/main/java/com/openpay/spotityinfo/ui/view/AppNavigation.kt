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
                // Navegamos con el ID del artista
                navController.navigate("albums/$artistId")
            }
        }

        composable(
            route = "albums/{artistId}",
            arguments = listOf(navArgument("artistId") { type = NavType.StringType })
        ) { backStackEntry ->
            val artistId = backStackEntry.arguments?.getString("artistId") ?: ""
            AlbumsScreen(artistId)
        }
    }
}