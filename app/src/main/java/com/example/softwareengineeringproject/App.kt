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
            .migration({ context ->

                /*
                    Source: https://github.com/realm/realm-kotlin/issues/992

                    abstract fun migrate(migrationContext: AutomaticSchemaMigration.MigrationContext)

                    this lambda is the implementation of the migrate function of AutomaticSchemaMigration.

                    context is of type AutomaticSchemaMigration.migrate

                    Realm creates an anonymous class that implements this AutomaticSchemaMigration.migrate,
                    which is the context

                    It's just like SAM (Single Abstract Method) in Kotlin where an interface with only one function
                    is created using a functional interface.

                    It abstracts the creation of an anonymous object that implements the interface.

                    oldRealm and newRealm are properties from MigrationContext that contains the old and new schema

                    newRealm only contains the updated objects, but it doesn't have the objects that weren't changed,
                    so mapping is still needed
                 */

                val oldRealm = context.oldRealm
                val newRealm = context.newRealm

                /*
                    Access old objects with the string based API as DynamicRealmObjects

                    A Dynamic Realm allows you to access and modify data in a Realm
                    file without knowing the schema at compile time.

                    "trust me, this object and field exist"

                    DynamicMutableRealm is just the mutable version of Dynamic Realm

                    .query() may return data with the same reference type that it received, but it can also
                    return a specific realm object just like in this case. This is because we're using the
                    'out' keyword, where it can return different types of data as long as the data
                    is a subclass of the received data type.

                    .find() returns an object that implements RealmResults with dynamicResults as the baseRealmObject
                    There must be an anonymous class that was created behind the scenes that implements RealmResults,
                    and that is oldObjects, which is also in a list form.

                 */

                val oldObjects = oldRealm.query("User").find()

                //Access migrated objects as mutable objects in the migrated realm. Unmodified schema properties will be left as is

                //val oldToNewObjectsMigration = realmListOf(DynamicMutableRealmObject)? = newRealm.findLatest(oldObjects[0])


                val oldObjectInMigratedRealm: RealmList<DynamicMutableRealmObject?> = realmListOf(
                    newRealm.findLatest(oldObjects[0]),
                    newRealm.findLatest(oldObjects[0]),

                )
                oldObjectInMigratedRealm?.let {
                    it.set("fieldName", "new field value")
                }

                // Fast iteration of all objects in the old Realm
                context.enumerate("ModelClass") { oldObject: DynamicRealmObject, newObject: DynamicMutableRealmObject? ->
                    // Some common use cases are highlighted at
                    // https://www.mongodb.com/docs/realm-sdks/kotlin/latest/library-base/io.realm.kotlin.migration/-automatic-schema-migration/-migration-context/index.html



                }

                // Creating of new objects from scratch in the migrated realm
                val scratchObjectInMigratedRealm = newRealm.copyToRealm(
                    DynamicMutableRealmObject.create("ModelClass", mapOf("fieldName" to "scratch value"))
                )

            })
            .build()

        realm

    }



    override fun onTerminate() {
        super.onTerminate()
        realm.close() // Close the Realm instance when the app terminates
    }

}