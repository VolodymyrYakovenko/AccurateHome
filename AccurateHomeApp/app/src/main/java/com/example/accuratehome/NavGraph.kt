package com.example.accuratehome

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.accuratehome.HomeScreen
import com.example.accuratehome.OnboardingScreen
import com.example.accuratehome.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable("SplashScreen"){
            SplashScreen(navController = navController)
        }
        composable("OnboardingScreen"){
            OnboardingScreen(navController = navController)
        }
        composable("HomeScreen"){
            HomeScreen(navController = navController)
        }
    }
}