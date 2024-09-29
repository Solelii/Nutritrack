package com.example.softwareengineeringproject

import android.app.Application
import com.example.softwareengineeringproject.db.diary.Breakfast
import com.example.softwareengineeringproject.db.diary.Diary
import com.example.softwareengineeringproject.db.diary.Dinner
import com.example.softwareengineeringproject.db.diary.Lunch
import com.example.softwareengineeringproject.db.diary.Snacks
import com.example.softwareengineeringproject.db.diary.water.Cup
import com.example.softwareengineeringproject.db.diary.water.Water
import com.example.softwareengineeringproject.db.food.NutritionalContent
import com.example.softwareengineeringproject.db.food.OpenFoodFactsFood
import com.example.softwareengineeringproject.db.food.SampleFood
import com.example.softwareengineeringproject.db.nutrient.BaseNutrient
import com.example.softwareengineeringproject.db.nutrient.Nutrient
import com.example.softwareengineeringproject.db.nutrient.RDA
import com.example.softwareengineeringproject.db.user.Accounts
import com.example.softwareengineeringproject.db.user.Goal
import com.example.softwareengineeringproject.db.user.NutrientIntakeHistory
import com.example.softwareengineeringproject.db.user.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

//extends to application(), which is the Base class for maintaining global application state.

class App: Application() {

    companion object{

        /*
            lateinit means the realm property will be initialized later (in the onCreate() function).
            It avoids initialization during object creation, ensuring the realm instance is created after the application starts.
         */

        lateinit var realm: Realm

    }

    /*
        onCreate() Function:
        onCreate() is called when the app is launched.
        codes in this class will be executed first before the OnCreate in the main activity. Maybe it is because in structure, application
        comes first?
     */

    override fun onCreate() {

        super.onCreate()

        /*
            Realm.open(): Opens a connection to the Realm database using the configuration provided.
            RealmConfiguration.create(): Creates a configuration for the Realm database.
            The schema defines the data model, i.e., the classes that represent data tables in the Realm database. Here, it includes:
            Address
            Course
            Student
            Teacher
            These classes represent the structure of your database. They are used to store and retrieve information from the Realm database.
         */

        realm = Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    Diary::class,
                    Breakfast::class,
                    Lunch::class,
                    Dinner::class,
                    Snacks::class,
                    Water::class,
                    Cup::class,
                    NutritionalContent::class,
                    OpenFoodFactsFood::class,
                    SampleFood::class,
                    Nutrient::class,
                    BaseNutrient::class,
                    RDA::class,
                    User::class,
                    NutrientIntakeHistory::class,
                    Goal::class,
                    Accounts::class,
                )
            )
        )
    }

    override fun onTerminate() {
        super.onTerminate()
        realm.close() // Close the Realm instance when the app terminates
    }

}