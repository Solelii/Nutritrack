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
import io.realm.kotlin.migration.AutomaticSchemaMigration

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

        //add migration

        val config = RealmConfiguration.Builder(
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
            .name("realm.realm")
            .schemaVersion(1)
            .migration(AutomaticSchemaMigration{
                val oldRealm = it.oldRealm
                val newRealm = it.newRealm

                // Access old objects with the string based API as DynamicRealmObjects

                /*
                    A Dynamic Realm allows you to access and modify data in a Realm
                    file without knowing the schema at compile time.

                    "trust me, this object and field exist"

                 */

                val oldObjects = oldRealm.query("User").find()

//                for (oldObject in oldObjects) {
//
//                    val fieldValue: String = oldObject.getValue("fieldName", String::class)
//
//                    val child: DynamicRealmObject? = oldObject.getObject("childObjects")
//                }



                // Access migrated objects as mutable objects in the migrated realm. Unmodified schema properties will be left as is
                val oldObjectInMigratedRealm: DynamicMutableRealmObject? =
                    newRealm.findLatest(oldObjects[0])
                oldObjectInMigratedRealm?.let {
                    it.set("fieldName", "new field value")
                }

                // Fast iteration of all objects in the old Realm
                it.enumerate("ModelClass") { oldObject: DynamicRealmObject, newObject: DynamicMutableRealmObject? ->
                    // Some common use cases are highlighted at
                    // https://www.mongodb.com/docs/realm-sdks/kotlin/1.0.2/library-base/-realm%20-kotlin%20-s-d-k/io.realm.kotlin.migration/-automatic-schema-migration/-migration-context/enumerate.html
                }

                // Creating of new objects from scratch in the migrated realm
                val scratchObjectInMigratedRealm = newRealm.copyToRealm(
                    DynamicMutableRealmObject.create("ModelClass", mapOf("fieldName" to "scratch value"))
                )
            })
            .build()



    }



    override fun onTerminate() {
        super.onTerminate()
        realm.close() // Close the Realm instance when the app terminates
    }

}