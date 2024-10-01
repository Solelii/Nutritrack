package com.example.softwareengineeringproject.db.nutrient

import io.realm.kotlin.types.EmbeddedRealmObject

class NutrientIntake : EmbeddedRealmObject {

    var nutrient: Nutrient? = null
    var intake: Double = 0.0

}