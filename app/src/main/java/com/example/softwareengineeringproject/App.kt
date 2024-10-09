package com.example.softwareengineeringproject

import android.app.Application
import com.example.softwareengineeringproject.db.diary.Breakfast
import com.example.softwareengineeringproject.db.diary.Diary
import com.example.softwareengineeringproject.db.diary.Dinner
import com.example.softwareengineeringproject.db.diary.Lunch
import com.example.softwareengineeringproject.db.diary.Snacks
import com.example.softwareengineeringproject.db.diary.water.Water
import com.example.softwareengineeringproject.db.food.NutritionalContent
import com.example.softwareengineeringproject.db.food.OpenFoodFactsFood
import com.example.softwareengineeringproject.db.food.SampleFood
import com.example.softwareengineeringproject.db.nutrient.DailyNutrientIntake
import com.example.softwareengineeringproject.db.nutrient.Nutrient
import com.example.softwareengineeringproject.db.nutrient.NutrientContent
import com.example.softwareengineeringproject.db.nutrient.NutrientIntakeHistory
import com.example.softwareengineeringproject.db.nutrient.RDA
import com.example.softwareengineeringproject.db.user.Accounts
import com.example.softwareengineeringproject.db.user.Birthdate
import com.example.softwareengineeringproject.db.user.Goal
import com.example.softwareengineeringproject.db.user.User
import com.example.softwareengineeringproject.db.user.WeightInput
import com.example.softwareengineeringproject.db.user.WeightRecord
import io.realm.kotlin.MutableRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.dynamic.DynamicMutableRealm
import io.realm.kotlin.dynamic.DynamicMutableRealmObject
import io.realm.kotlin.dynamic.DynamicRealm
import io.realm.kotlin.dynamic.DynamicRealmObject
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.migration.AutomaticSchemaMigration
import io.realm.kotlin.types.RealmList

//extends to application(), which is the Base class for maintaining global application state.

class App: Application() {

    companion object{

        /*
            lateinit means the realm property will be initialized later (in the onCreate() function).
            It avoids initialization during object creation, ensuring the realm instance is created after the application starts.
         */

        /*
            Realm = read only database
            MutableRealm = read write database
            There's no way to configure a mutable realm. Create a realm instance first, then make it
            into a mutable realm using realm.write

            This is because MutableRealm doesn't have the companion object where open function is in
            and opens a realm instance

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
            RealmConfiguration.Builder.build returns a RealmConfiguration which is used to define the schema, version, and other
            kinds of configuration to the realm database.

            This is passed to Realm.open() to open the realm with the specific configurations
         */

        //add migration

//        val config = RealmConfiguration.Builder(
//            schema = setOf(
//                    //Diary
//                    Diary::class,
//                    Breakfast::class,
//                    Lunch::class,
//                    Dinner::class,
//                    Snacks::class,
//                    Water::class,
//
//                    //Food
//                    NutritionalContent::class,
//                    OpenFoodFactsFood::class,
//                    SampleFood::class,
//
//                    //Nutrient
//                    DailyNutrientIntake::class,
//                    Nutrient::class,
//                    NutrientContent::class,
//                    NutrientIntakeHistory::class,
//                    RDA::class,
//
//                    //User
//                    User::class,
//                    Goal::class,
//                    Accounts::class,
//                    WeightRecord::class,
//                    WeightInput::class,
//                    Birthdate::class
//                )
//        )
//            .deleteRealmIfMigrationNeeded()
//            .name("realm.realm")
//            .build()
//        realm = Realm.open(config)

        realm = Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    //Diary
                    Diary::class,
                    Breakfast::class,
                    Lunch::class,
                    Dinner::class,
                    Snacks::class,
                    Water::class,

                    //Food
                    NutritionalContent::class,
                    OpenFoodFactsFood::class,
                    SampleFood::class,

                    //Nutrient
                    DailyNutrientIntake::class,
                    Nutrient::class,
                    NutrientContent::class,
                    NutrientIntakeHistory::class,
                    RDA::class,

                    //User
                    User::class,
                    Goal::class,
                    Accounts::class,
                    WeightRecord::class,
                    WeightInput::class,
                    Birthdate::class
                )
            )
        )
    }

    override fun onTerminate() {
        super.onTerminate()
        realm.close() // Close the Realm instance when the app terminates
    }

}