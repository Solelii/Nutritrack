package com.example.softwareengineeringproject.db.user

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList

class WeightRecord: EmbeddedRealmObject {

    var weightRecord: RealmList<WeightInput>? = null


}