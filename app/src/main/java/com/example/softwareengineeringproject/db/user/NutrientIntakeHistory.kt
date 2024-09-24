package com.example.softwareengineeringproject.db.user

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.bson.types.ObjectId

class NutrientIntakeHistory: RealmObject {

    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var dailyNutrientIntake: RealmList<DailyNutrientIntake> = realmListOf()

}