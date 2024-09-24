package com.example.softwareengineeringproject.daggerhilt.data

import com.example.softwareengineeringproject.db.nutrient.Nutrient
import com.example.softwareengineeringproject.db.nutrient.RDA
import com.example.softwareengineeringproject.db.user.User
import com.example.softwareengineeringproject.interfaces.NutrientDataManipulation

////Class that contains the implementations of the interface
////The dependency that is passed
//class NutrientDataManipulationImplementation (
//    //TBD
//    //Probably will need some injections from realmDB
//):NutrientDataManipulation {
//    override suspend fun calculateRDA(nutrient: Nutrient, user: User) : RDA{
//        val rdaValues = _getRDAValuesForUser(user)
//        //searches for the key which has the same name as the nutrient.nutrientId
//        // '?' means that it is nullable and won't cause error
//        //
//        return rdaValues[nutrient.nutrientId] ?: nutrient.recommendedDietaryAllowance
//    }
//    //getter function
//    private fun _getRDAValuesForUser (user: User): Map<String, RDA>{
//        //should get from realmDB
//        //not real implementation
//        return mapOf(
//            "Ca" to RDA(2500.0, 1000.0),
//            "Fe" to RDA(45.0, 18.0)
//        )
//    }
//}