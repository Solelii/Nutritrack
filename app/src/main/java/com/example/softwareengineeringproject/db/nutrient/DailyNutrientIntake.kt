package com.example.softwareengineeringproject.db.nutrient

import com.example.softwareengineeringproject.db.nutrient.Nutrient
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class DailyNutrientIntake: RealmObject {

    var creationDate: RealmInstant = RealmInstant.now()
    //make default nutrients locally
    var nutrientIntake: RealmList<NutrientIntake> = realmListOf()

}