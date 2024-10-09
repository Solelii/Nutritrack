package com.example.softwareengineeringproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.softwareengineeringproject.App
import com.example.softwareengineeringproject.App.Companion.realm
import com.example.softwareengineeringproject.db.diary.Diary
import com.example.softwareengineeringproject.db.food.NutritionalContent
import com.example.softwareengineeringproject.db.nutrient.DailyNutrientIntake
import com.example.softwareengineeringproject.db.nutrient.Nutrient
import com.example.softwareengineeringproject.db.nutrient.NutrientContent
import com.example.softwareengineeringproject.db.user.User
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DataManipulator {
    companion object{
        suspend fun resetDailyNutrientIntake(dailyNutrientIntake: DailyNutrientIntake) {
            realm.write {
                //sets each nutrient's content in nutrientIntake to 0
                dailyNutrientIntake.nutrientIntake.forEach {
                    it.content = 0.0
                }
            }
        }

        fun resetNutrientContent() : RealmList<NutrientContent> {
            return realmListOf(
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
        //can use inline?
        //can use operator?
        //deleteFoodFromDailyNutrientIntake is similar to calculateDailyNutrientIntake. Reduce boilerplate code
        suspend fun deleteNutrient(
            nutrientContent: RealmList<NutritionalContent>,
            dailyNutrientIntake : DailyNutrientIntake
        ){
            realm.write {
                for (nutrient in nutrientContent) {
                    for (nutrientIntake in dailyNutrientIntake.nutrientIntake) {
                        if (nutrientIntake.nutrient!!.nutrientName == nutrient.nutrient!!.nutrientName) {
                            //retrieves the nutrient in dailyNutrientIntake
                            //add nutrient.content to dailyNutrientIntake.nutrient
                            dailyNutrientIntake.nutrientIntake
                                .get(dailyNutrientIntake.nutrientIntake.indexOf(nutrientIntake))
                                .content -= nutrient.content
                            break
                        }
                    }
                }
            }
            return dailyNutrientIntake
        }

        //better if the nutrientContent of the food is passed here instead of diary
        suspend fun addNutrient(
            nutrientContent : RealmList<NutritionalContent>,
            dailyNutrientIntake : DailyNutrientIntake
        ){
            realm.write {
                for (nutrient in nutrientContent) {
                    for (nutrientIntake in dailyNutrientIntake.nutrientIntake) {
                        if (nutrientIntake.nutrient!!.nutrientName == nutrient.nutrient!!.nutrientName) {
                            //retrieves the nutrient in dailyNutrientIntake
                            //add nutrient.content to dailyNutrientIntake.nutrient
                            dailyNutrientIntake.nutrientIntake
                                .get(dailyNutrientIntake.nutrientIntake.indexOf(nutrientIntake))
                                .content += nutrient.content
                            break
                        }
                    }
                }
            }
            return dailyNutrientIntake
        }

        fun resetDiary(diary: Diary, realm: Realm){

            diary.breakfast?.foodEntry?.forEach {

            }
        }
        fun updateDiary(diary: Diary){

        }

        //must have a function that creates dailynutrientintake and diary initialization

        fun getUserAsStateFlow(scope: CoroutineScope): StateFlow<List<User>> {
            /*
        We query Courses since it is connected to all of the objects

        .asFlow() returns the query as Flow so that we can react to the changes from the database asynchronously

        .map function is used to transform the data emitted by a flow.
        Specifically, the flow here is a query result from the Realm database,
        and .map allows you to change or modify that result before it is passed along downstream.

        .map is a transforming function from Kotlin's Flow API.
        It takes each emitted item (in this case, results, which is the query result from Realm) and transforms it.

        results.list.toList() is used to convert the query result (RealmResults) into a Kotlin List.

        .map function takes the Realm query result (which is emitted as RealmResults)
        and transforms it into a regular Kotlin List before passing it further downstream in the flow.

        .map is used to convert the data format from RealmResults to List<User>.
     */

            val user = realm
                .query<User>("User")
                .asFlow()
                .map { results ->
                    results.list.toList()
                }

                /*
                    he .stateIn() function in Kotlin’s Flow API is used to convert a Flow into
                    a StateFlow, which is a state-holder that can be observed.
                 */

                .stateIn(
                    /*
                        viewModelScope:

                        This is a coroutine scope tied to the lifecycle of the Repository
                        Using coroutineScope ensures that the flow is automatically canceled
                        when Repository is cleared, preventing memory leaks and unnecessary computations.

                     */
                    scope,

                    /*
                        SharingStarted.WhileSubscribed():

                        This parameter defines the strategy for when the StateFlow should be active.
                        SharingStarted.WhileSubscribed() means the flow will remain active while there are active subscribers
                        (collectors).

                        It will be kept alive as long as there is at least one collector observing the flow.
                        Once all collectors are gone, the flow will be stopped.
                     */

                    SharingStarted.WhileSubscribed(),

                    /*
                        Initial value before any data is emitted
                     */

                    emptyList()
                )
            return user
        }

    }

}