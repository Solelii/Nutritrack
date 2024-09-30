package com.example.softwareengineeringproject.db.nutrient

import com.example.softwareengineeringproject.db.food.DailyNutrientIntake
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class NutrientIntakeHistory : RealmObject {

    var dailyNutrientIntake : RealmList<DailyNutrientIntake> = realmListOf()

}