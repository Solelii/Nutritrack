package com.example.softwareengineeringproject.db.user

import io.realm.kotlin.types.EmbeddedRealmObject

class SocialAccounts: EmbeddedRealmObject {

    var gmail: String? = ""
    var facebook: String? = ""

}