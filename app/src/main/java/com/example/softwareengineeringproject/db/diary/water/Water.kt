package com.example.softwareengineeringproject.db.diary.water

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject
import java.util.Date

class Water: RealmObject {

    var cupSize: Double = 16.0
    var total: Double = 0.0

}