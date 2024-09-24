package com.example.softwareengineeringproject.db.nutrient

import io.realm.kotlin.types.EmbeddedRealmObject

//Base Nutrient for DailyNutrient and NutritionalContent

open class BaseNutrient: EmbeddedRealmObject {

    var nutrient: Nutrient = Nutrient()

}