package com.example.softwareengineeringproject.db.diary.water

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject
import java.util.Date

class Water: RealmObject {
    //Using US fluid ounces
    var ouncePerCup: Double = 8.0
    var total: Double = 0.0

}