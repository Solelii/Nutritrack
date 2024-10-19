package com.example.softwareengineeringproject.db.nutrient

import io.realm.kotlin.types.EmbeddedRealmObject

class RDA: EmbeddedRealmObject {

    var upperLimit: Double = 0.0
    var adequateIntake: Double = 0.0

}