package com.example.softwareengineeringproject.db.nutrient

import io.realm.kotlin.types.RealmObject


//Nutrient must be a frozen-object

class Nutrient: RealmObject {

    var nutrientName: String = ""
    var unit: String = ""
    var dietaryReferenceIntake: DRI? = null

    /*
        Vitamin A
        Vitamin D
        Vitamin C

        Minerals
        Calcium
        Potassium
        Sodium (high intake)
        Magnesium
        Iron (most common)
        Zinc (second most deficient)
        Selenium

        Calorie
            Fat
                saturated fat
                trans fat
                polyunsaturated fat
                monounsaturated fat
                cholesterol
            Protein
            carbohydrates
        Water

     */
}