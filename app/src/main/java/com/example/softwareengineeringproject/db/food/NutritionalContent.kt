package com.example.softwareengineeringproject.db.food

import com.example.softwareengineeringproject.db.nutrient.Nutrient
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject

//will cause an error if it is an embedded object because it holds a realm object
//realm object could persist... error
class NutritionalContent: RealmObject{

    var nutrient: Nutrient? = null
    var content: Double = 0.0

}