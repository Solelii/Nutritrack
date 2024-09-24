package com.example.softwareengineeringproject

// A sealed class 'Screen' representing all the different screens (or routes) in the app.
// Each object within the class defines a specific screen with its associated route as a string.
sealed class Screen(val route: String) {

    // Data object representing the Dashboard screen with its route name as "dashboard_screen".
    data object Dashboard : Screen("dashboard_screen")

    // Data object representing the Diary screen with its route name as "diary_screen".
    data object Diary : Screen("diary_screen")

    // Data object representing the Profile screen with its route name as "profile_screen".
    data object Profile : Screen("profile_screen")

    // Data object representing the Notification screen with its route name as "notification_screen".
    data object Notification : Screen("notification_screen")

    // Data object representing the Nutrient Intake Summary screen with its route name as "nutrient_summary_screen".
    data object NutrientIntakeSummary : Screen("nutrient_summary_screen")

    // Data object representing the Water Intake Summary screen with its route name as "water_intake_summary_screen".
    data object WaterIntakeSummary : Screen("water_intake_summary_screen")

    // Data object representing the Weight screen with its route name as "weight_screen".
    data object Weight : Screen("weight_screen")

    // Data object representing the Search Food screen with its route name as "search_food_screen".
    data object SearchFood : Screen("search_food_screen")

    // Data object representing the Filter screen with its route name as "filter_screen".
    data object Filter : Screen("filter_screen")

    // Data object representing the Food Option screen with its route name as "food_option_screen".
    data object FoodOption : Screen("food_option_screen")

    // Data object representing the Food Info screen with its route name as "food_info_screen".
    data object FoodInfo : Screen("food_info_screen")
}
