package com.example.softwareengineeringproject.db.diary

import com.example.softwareengineeringproject.db.food.SampleFood
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
import java.util.Date

class Breakfast: EmbeddedRealmObject {

    var foodEntry: RealmList<SampleFood> = realmListOf()

}