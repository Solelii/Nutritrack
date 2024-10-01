package com.example.softwareengineeringproject.db.user

import io.realm.kotlin.types.EmbeddedRealmObject

class Goal: EmbeddedRealmObject {

    var goal: String = ""
    var currentWeight: Double = 0.0
    var targetWeight: Double = 0.0
    var caloriesPerDay: Double = 0.0

}