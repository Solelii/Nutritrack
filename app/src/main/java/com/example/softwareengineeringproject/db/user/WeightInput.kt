package com.example.softwareengineeringproject.db.user

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmInstant

class WeightInput : EmbeddedRealmObject {

    var input : Double = 0.0
    var date : RealmInstant = RealmInstant.now()

}