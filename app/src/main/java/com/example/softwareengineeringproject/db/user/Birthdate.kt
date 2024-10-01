package com.example.softwareengineeringproject.db.user

import io.realm.kotlin.types.EmbeddedRealmObject

class Birthdate : EmbeddedRealmObject {

    var month: Int = 0
    var day: Int = 0
    var year: Int = 0

}