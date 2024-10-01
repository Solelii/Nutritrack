package com.example.softwareengineeringproject.db.nutrient

import io.realm.kotlin.types.EmbeddedRealmObject

class NutrientContent : EmbeddedRealmObject {

    var nutrient: Nutrient? = null
    var content: Double = 0.0

}