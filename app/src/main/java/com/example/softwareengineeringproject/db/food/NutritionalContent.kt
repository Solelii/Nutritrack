package com.example.softwareengineeringproject.db.food

import com.example.softwareengineeringproject.db.nutrient.BaseNutrient
import io.realm.kotlin.types.EmbeddedRealmObject

class NutritionalContent: EmbeddedRealmObject, BaseNutrient() {

    var amount: Double = 0.0

}