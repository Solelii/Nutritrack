package com.example.softwareengineeringproject.db.food

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import io.realm.kotlin.types.annotations.PrimaryKey
import org.bson.types.ObjectId

class SampleFood: RealmObject {
    /*
        e: file:///C:/Users/ACER/AndroidStudioProjects/SoftwareEngineeringProject/app/src/main/java/com/example/softwareengineeringproject/db/food/SampleFood.kt:10:5
        [Realm] Realm does not support persisting properties of this type.
        Mark the field with `@Ignore` to suppress this error.
    */
    var foodName: String = ""
    var nutritionalContent: RealmList<NutritionalContent> = realmListOf()
    var barcode: String = ""

}