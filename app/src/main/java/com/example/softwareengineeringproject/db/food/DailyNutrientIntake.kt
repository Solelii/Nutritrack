package com.example.softwareengineeringproject.db.food

import com.example.softwareengineeringproject.db.nutrient.Nutrient
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmObject

class DailyNutrientIntake: RealmObject {

    var creationDate: RealmInstant = RealmInstant.now()
    var nutrient: Nutrient? = null
    var intake: Double = 0.0

}