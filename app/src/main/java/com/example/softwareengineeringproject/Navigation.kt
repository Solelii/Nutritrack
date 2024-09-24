package com.example.softwareengineeringproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.softwareengineeringproject.screens.dashboard.Dashboard
import com.example.softwareengineeringproject.screens.Diary
import com.example.softwareengineeringproject.screens.Filter
import com.example.softwareengineeringproject.screens.FoodInfo
import com.example.softwareengineeringproject.screens.FoodOption
import com.example.softwareengineeringproject.screens.NutrientIntakeSummary
import com.example.softwareengineeringproject.screens.Profile
import com.example.softwareengineeringproject.screens.SearchFood
import com.example.softwareengineeringproject.screens.WaterIntakeSummary
import com.example.softwareengineeringproject.screens.Weight

@Composable

// This is the Navigation function which sets up navigation within the app using Jetpack Navigation Component in Compose.
fun Navigation(){
    // Creates a NavController that handles app navigation.
    val navController = rememberNavController()

    // NavHost sets up the navigation graph. It defines the starting destination and manages navigation between composables.
    NavHost(navController = navController, startDestination = Screen.Dashboard.route){

        // This is a composable destination for the Dashboard screen.
        composable(route = Screen.Dashboard.route){
            // Navigates to the Dashboard screen and passes the navController for further navigation from the Dashboard.
            Dashboard(navController = navController)
        }

        // Composable destination for the FoodOption screen.
        composable(route = Screen.FoodOption.route){
            // Navigates to the FoodOption screen and passes the navController.
            FoodOption(navController = navController)
        }

        // Composable destination for the FoodInfo screen.
        composable(route = Screen.FoodInfo.route){
            // Navigates to the FoodInfo screen and passes the navController.
            FoodInfo(navController = navController)
        }

        // Composable destination for the NutrientIntakeSummary screen.
        composable(route = Screen.NutrientIntakeSummary.route){
            // Navigates to the NutrientIntakeSummary screen and passes the navController.
            NutrientIntakeSummary(navController = navController)
        }

        // Composable destination for the Diary screen.
        composable(route = Screen.Diary.route){
            // Navigates to the Diary screen and passes the navController.
            Diary(navController = navController)
        }

        // Composable destination for the Weight screen.
        composable(route = Screen.Weight.route){
            // Navigates to the Weight screen and passes the navController.
            Weight(navController = navController)
        }

        // Composable destination for the Filter screen.
        composable(route = Screen.Filter.route){
            // Navigates to the Filter screen and passes the navController.
            Filter(navController = navController)
        }

        // Composable destination for the WaterIntakeSummary screen.
        composable(route = Screen.WaterIntakeSummary.route){
            // Navigates to the WaterIntakeSummary screen and passes the navController.
            WaterIntakeSummary(navController = navController)
        }

        // Composable destination for the Profile screen.
        composable(route = Screen.Profile.route){
            // Navigates to the Profile screen and passes the navController.
            Profile(navController = navController)
        }

        // Composable destination for the SearchFood screen.
        composable(route = Screen.SearchFood.route){
            // Navigates to the SearchFood screen and passes the navController.
            SearchFood(navController = navController)
        }
    }
}
