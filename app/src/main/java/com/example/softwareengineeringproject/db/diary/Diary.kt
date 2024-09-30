package com.example.softwareengineeringproject.db.diary

import com.example.softwareengineeringproject.db.diary.water.Water
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.annotations.Ignore
import java.util.Date

class Diary: EmbeddedRealmObject {

    //@Ignore
    /*
        e: file:///C:/Users/ACER/AndroidStudioProjects/SoftwareEngineeringProject/app/src/main/java/com/example/softwareengineeringproject/db/food/SampleFood.kt:10:5
        [Realm] Realm does not support persisting properties of this type.
        Mark the field with `@Ignore` to suppress this error.
     */
    var creationDate: RealmInstant = RealmInstant.now()
    var breakfast: Breakfast = Breakfast()
    var lunch: Lunch = Lunch()
    var snacks: Snacks = Snacks()
    var dinner: Dinner = Dinner()
    var water: Water = Water()

}