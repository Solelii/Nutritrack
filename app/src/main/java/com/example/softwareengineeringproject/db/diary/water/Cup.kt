package com.example.softwareengineeringproject.db.diary.water

import com.example.softwareengineeringproject.db.user.User
import io.realm.kotlin.ext.backlinks
import io.realm.kotlin.query.RealmQuery
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject

class Cup: RealmObject {

    var cupSize: Double = 16.0

}