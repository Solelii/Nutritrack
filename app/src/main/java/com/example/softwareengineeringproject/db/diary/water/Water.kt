package com.example.softwareengineeringproject.db.diary.water

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject
import java.util.Date

class Water: RealmObject {

    var cup: Cup? = null
    var total: Double = 0.0

}