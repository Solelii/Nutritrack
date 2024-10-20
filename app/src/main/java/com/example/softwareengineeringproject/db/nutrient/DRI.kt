package com.example.softwareengineeringproject.db.nutrient

import io.realm.kotlin.types.EmbeddedRealmObject

class DRI: EmbeddedRealmObject {

    /*
        Establishes the maximum daily intake unlikely to cause adverse health effects.
     */
    var tolerableUpperIntakeLevel: Double = 0.0
    /*
        Provides an estimated intake level when evidence is insufficient to establish an RDA.
        adequateIntake and tolerableUpperIntakeLevel is going to represent the lower range and upper range of
        Acceptable Macronutrient Distribution Ranges (AMDR) for macros.
     */
    var adequateIntake: Double = 0.0
    /*
        RDA (Recommended Dietary Allowance): Indicates the daily intake level sufficient for most healthy individuals.
        I'm gonna use adequate intake for RDA for simplicity
     */
    var recommendedDietaryAllowance: Double = 0.0

}