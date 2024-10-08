package com.example.softwareengineeringproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.softwareengineeringproject.App
import com.example.softwareengineeringproject.db.diary.Breakfast
import com.example.softwareengineeringproject.db.diary.Diary
import com.example.softwareengineeringproject.db.diary.Dinner
import com.example.softwareengineeringproject.db.diary.Lunch
import com.example.softwareengineeringproject.db.diary.Snacks
import com.example.softwareengineeringproject.db.diary.water.Water
import com.example.softwareengineeringproject.db.food.NutritionalContent
import com.example.softwareengineeringproject.db.food.SampleFood
import com.example.softwareengineeringproject.db.nutrient.DailyNutrientIntake
import com.example.softwareengineeringproject.db.nutrient.Nutrient
import com.example.softwareengineeringproject.db.nutrient.NutrientContent
import com.example.softwareengineeringproject.db.nutrient.NutrientIntakeHistory
import com.example.softwareengineeringproject.db.user.Birthdate
import com.example.softwareengineeringproject.db.user.Goal
import com.example.softwareengineeringproject.db.user.User
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    /*
        _realm holds a reference to the Realm database instance.
        It is initialized by retrieving the realm instance from the MyApp class.

        The _realm variable is used to perform database operations, such as writing and reading data.
     */
    private val realm = App.realm

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

                This is a coroutine scope tied to the lifecycle of the ViewModel.
                Using viewModelScope ensures that the flow is automatically canceled
                when the ViewModel is cleared, preventing memory leaks and unnecessary computations.

             */
            viewModelScope,

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

    /*
        This function creates sample data entries in the Realm database.

        It is executed within the viewModelScope.launch block,
        meaning the function is executed asynchronously using Kotlin coroutines.

     */


    /*
        Used to initialize realmdb with the entries in this function.
        Once initialized, the data will persist in the database.
     */

    //we can use lazy here to initialize one time

//    init {
//
//        createSampleEntries()
//    }

    private fun createSampleEntries() {

        viewModelScope.launch {

            //clearDatabase()

            /*
                The write block is a Realm transaction where database changes (insertions/updates) are made.
            */

            realm.write {

                /*
                    apply is used to initialize the properties of each Address object within a single block.
                 */

                /*
                    Sample users
                 */

                var user1 = User().apply {

                    firstName = "Holo"
                    birthDate = Birthdate().apply{
                        month = 1
                        day = 1
                        year = 1
                    }
                    height = 170.0
                    goal = Goal().apply {
                        goal = "Lose Weight"
                        currentWeight = 60.0
                        targetWeight = 50.0
                    }
                    activityLevel = 1
                    sex = 0
                    password = "samplePassword"
                }

                var user2 = User().apply {

                    firstName = "Miyagi"
                    birthDate = Birthdate().apply{
                        month = 2
                        day = 2
                        year = 2
                    }
                    goal = Goal().apply {
                        goal = "Maintain Weight"
                        currentWeight = 45.0
                        //should not ask for user for target weight because it is already
                        //stated that the user wants to maintain his/her weight
                    }
                    height = 170.0
                    activityLevel = 1
                    sex = 0
                    password = "samplePassword2"
                }

                var user3 = User().apply {

                    firstName = "Eri"
                    birthDate = Birthdate().apply{
                        month = 2
                        day = 2
                        year = 2
                    }
                    goal = Goal().apply {
                        goal = "Gain Weight"
                        currentWeight = 40.0
                        targetWeight = 50.0
                    }
                    height = 170.0
                    activityLevel = 1
                    sex = 0
                    password = "samplePassword3"
                }

                var diary1 = Diary().apply{
                    creationDate = RealmInstant.now()
                    breakfast = Breakfast().apply{
                        foodEntry = realmListOf(
                            SampleFood().apply{
                                foodName = "Oreo"
                                nutritionalContent = realmListOf(
                                    NutritionalContent().apply{
                                        nutrient = Nutrient().apply{
                                            nutrientName = "Saturated Fat"
                                            unit = "g"
                                        }
                                        content = 6.0
                                    },
                                    NutritionalContent().apply{
                                        nutrient = Nutrient().apply{
                                            nutrientName = "Cholesterol"
                                            unit = "g"
                                        }
                                        content = 0.0
                                    },
                                    NutritionalContent().apply{
                                        nutrient = Nutrient().apply{
                                            nutrientName = "Sodium"
                                            unit = "mg"
                                        }
                                        content = 471.0
                                    },
                                    NutritionalContent().apply{
                                        nutrient = Nutrient().apply{
                                            nutrientName = "Potassium"
                                            unit = "mg"
                                        }
                                        content = 180.0
                                    },
                                )
                            }
                        )
                    }
                    lunch = Lunch().apply{
                        foodEntry = realmListOf(
                            SampleFood().apply{

                            },
                            SampleFood().apply{

                            }
                        )
                    }
                    dinner = Dinner().apply{
                        foodEntry = realmListOf(
                            SampleFood().apply{

                            },
                            SampleFood().apply{

                            }
                        )
                    }
                    snacks = Snacks().apply{
                        foodEntry = realmListOf(
                            SampleFood().apply{

                            },
                            SampleFood().apply{

                            }
                        )
                    }
                    water = Water().apply{
                        total = 92.0
                    }
                }

                user1.diary = diary1


                var nutrientIntakeHistory1 = NutrientIntakeHistory().apply{

                    dailyNutrientIntake = realmListOf(createDailyNutrientIntake())

                }

                user1.nutrientIntakeHistory = nutrientIntakeHistory1

                //use frozen to frozen the diary for this read/write
                //`!!` non-nullable operator
                user1.nutrientIntakeHistory = calculateDailyNutrientIntake(user1.diary!!)

            }

        }
    }

    private fun calculateDailyNutrientIntake(diary : Diary): NutrientIntakeHistory? {



    }



    private fun createDailyNutrientIntake(): DailyNutrientIntake{
        return DailyNutrientIntake().apply {
            nutrientIntake = createDefaultNutrientContent()
            creationDate = RealmInstant.now()
        }
    }
    private fun createDefaultNutrientContent(): RealmList<NutrientContent> {
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
    private suspend fun clearDatabase() {
        realm.write{
            deleteAll()
        }
    }

}