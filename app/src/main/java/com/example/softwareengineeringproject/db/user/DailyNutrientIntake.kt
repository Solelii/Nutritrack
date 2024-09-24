package com.example.softwareengineeringproject.db.user

import com.example.softwareengineeringproject.db.nutrient.BaseNutrient
import java.util.Date

class DailyNutrientIntake: BaseNutrient(){

    var creationDate: Date = Date()
    var intake: Double = 0.0

}