package com.example.softwareengineeringproject.db.food

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.bson.types.ObjectId

class SampleFood: RealmObject {

    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var foodName: String = ""
    var nutritionalContent: NutritionalContent = NutritionalContent()
    var barcode: String = ""

}