package com.example.softwareengineeringproject.db.user

import com.example.softwareengineeringproject.db.food.DailyNutrientIntake
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import io.realm.kotlin.types.annotations.PrimaryKey
import org.bson.types.ObjectId

class NutrientIntakeHistory: EmbeddedRealmObject {

    var dailyNutrientIntake: RealmList<DailyNutrientIntake> = realmListOf()

}