package com.example.softwareengineeringproject.db.nutrient

import com.example.softwareengineeringproject.db.nutrient.Nutrient
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class DailyNutrientIntake: RealmObject {

    var creationDate: RealmInstant = RealmInstant.now()
    //make default nutrients locally
    var nutrientIntake: RealmList<NutrientContent> =
        realmListOf(
            NutrientContent().apply {
            nutrient = Nutrient().apply {
                nutrientName = "Vitamin A"
                unit = "µg"
            }
            content = 0.0
        },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Vitamin C"
                    unit = "µg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Calcium"
                    unit = "mg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Potassium"
                    unit = "mg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Sodium"
                    unit = "mg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Magnesium"
                    unit = "mg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Iron"
                    unit = "mg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Zinc"
                    unit = "mg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Selenium"
                    unit = "µg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Saturated Fat"
                    unit = "g"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Trans Fat"
                    unit = "g"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Polyunsaturated Fat"
                    unit = "g"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Monounsaturated Fat"
                    unit = "g"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Cholesterol"
                    unit = "mg"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Protein"
                    unit = "g"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Carbohydrates"
                    unit = "g"
                }
                content = 0.0
            },
            NutrientContent().apply {
                nutrient = Nutrient().apply {
                    nutrientName = "Water"
                    unit = "mL"
                }
                content = 0.0
            }
        )
}