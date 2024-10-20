package com.example.softwareengineeringproject.db.user

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class WeightRecord: RealmObject {

    var weightRecord: RealmList<WeightInput> = realmListOf()


}