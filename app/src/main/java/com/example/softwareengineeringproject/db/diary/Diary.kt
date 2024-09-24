package com.example.softwareengineeringproject.db.diary

import com.example.softwareengineeringproject.db.diary.water.Water
import io.realm.kotlin.types.EmbeddedRealmObject
import java.util.Date

class Diary: EmbeddedRealmObject {

    val creationDate: Date = Date()
    var breakfast: Breakfast = Breakfast()
    var lunch: Lunch = Lunch()
    var snacks: Snacks = Snacks()
    var dinner: Dinner = Dinner()
    var water: Water = Water()

}