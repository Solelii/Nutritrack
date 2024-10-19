package com.example.softwareengineeringproject

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.softwareengineeringproject.db.diary.Breakfast
import com.example.softwareengineeringproject.db.diary.Diary
import com.example.softwareengineeringproject.db.diary.Dinner
import com.example.softwareengineeringproject.db.diary.Lunch
import com.example.softwareengineeringproject.db.diary.Snacks
import com.example.softwareengineeringproject.db.diary.water.Water
import com.example.softwareengineeringproject.db.food.NutritionalContent
import com.example.softwareengineeringproject.db.food.OpenFoodFactsFood
import com.example.softwareengineeringproject.db.food.SampleFood
import com.example.softwareengineeringproject.db.nutrient.DailyNutrientIntake
import com.example.softwareengineeringproject.db.nutrient.Nutrient
import com.example.softwareengineeringproject.db.nutrient.NutrientContent
import com.example.softwareengineeringproject.db.nutrient.NutrientIntakeHistory
import com.example.softwareengineeringproject.db.nutrient.RDA
import com.example.softwareengineeringproject.db.user.Accounts
import com.example.softwareengineeringproject.db.user.Birthdate
import com.example.softwareengineeringproject.db.user.Goal
import com.example.softwareengineeringproject.db.user.User
import com.example.softwareengineeringproject.db.user.WeightInput
import com.example.softwareengineeringproject.db.user.WeightRecord
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.realmListOf
import java.time.LocalDate

//extends to application(), which is the Base class for maintaining global application state.

class App: Application() {

    companion object{

        /*
            lateinit means the realm property will be initialized later (in the onCreate() function).
            It avoids initialization during object creation, ensuring the realm instance is created after the application starts.
         */

        /*
            Realm = read only database
            MutableRealm = read write database
            There's no way to configure a mutable realm. Create a realm instance first, then make it
            into a mutable realm using realm.write

            This is because MutableRealm doesn't have the companion object where open function is in
            and opens a realm instance

         */

        lateinit var realm: Realm

    }

    /*
        onCreate() Function:
        onCreate() is called when the app is launched.
        codes in this class will be executed first before the OnCreate in the main activity. Maybe it is because in structure, application
        comes first?
     */

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {

        super.onCreate()

        /*
            RealmConfiguration.Builder.build returns a RealmConfiguration which is used to define the schema, version, and other
            kinds of configuration to the realm database.

            This is passed to Realm.open() to open the realm with the specific configurations
         */

        //add migration

        val config = RealmConfiguration.Builder(
            schema = setOf(
                    //Diary
                    Diary::class,
                    Breakfast::class,
                    Lunch::class,
                    Dinner::class,
                    Snacks::class,
                    Water::class,

                    //Food
                    NutritionalContent::class,
                    OpenFoodFactsFood::class,
                    SampleFood::class,

                    //Nutrient
                    DailyNutrientIntake::class,
                    Nutrient::class,
                    NutrientContent::class,
                    NutrientIntakeHistory::class,
                    RDA::class,

                    //User
                    User::class,
                    Goal::class,
                    Accounts::class,
                    WeightRecord::class,
                    WeightInput::class,
                    Birthdate::class
                )
        )
            .deleteRealmIfMigrationNeeded()
            .name("realm.realm")
            //Callback that will be triggered in order to write initial data when the Realm file is created for the first time.
            .initialData {

                val user = copyToRealm(User().apply {
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
                    sex = "Female"
                    password = "samplePassword"
                })
                val dailyNutrientIntake = copyToRealm(DailyNutrientIntake().apply {
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
                                    nutrientName = "Vitamin D"
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
                                    nutrientName = "Calories"
                                    unit = "kcal"
                                }
                                content = 0.0
                            },
                            NutrientContent().apply {
                                nutrient = Nutrient().apply {
                                    nutrientName = "Total Fat"
                                    unit = "g"
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
                                    nutrientName = "Monounsaturated Fat"
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
                                    nutrientName = "Trans Fat"
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
                    })

                val age = run {
                    val currentDate = LocalDate.now()

                    val birthdate = LocalDate.of(user.birthDate!!.year, user.birthDate!!.month, user.birthDate!!.day)

                    var age = currentDate.year - birthdate!!.year

                    /*
                        if the current month in int is less than the user's birth month, then the user still hasn't
                        celebrated his/hers birthday, meaning we have to deduct a year on age.
                        if the current month is the same with the birth month, then we have to check first if
                        the user still hasn't celebrated his/her birthday.
                     */

                    if (currentDate.monthValue < birthdate.monthValue || (currentDate.monthValue == birthdate.monthValue
                                && currentDate.dayOfMonth < birthdate.dayOfMonth)){
                        age -= 1
                    }
                    age
                }

                //can reduce code
                if (user.sex == "Male") {
                    //Vitamin A
                    dailyNutrientIntake.nutrientIntake[0].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3){
                                upperLimit = 600.0
                                adequateIntake = 300.0
                            }else if (age in 4..8){
                                upperLimit = 900.0
                                adequateIntake = 400.0
                            }else if (age in 9..13){
                                upperLimit = 1700.0
                                adequateIntake = 600.0
                            }else if (age in 14..18){
                                upperLimit = 2800.0
                                adequateIntake = 900.0
                            }else if (age >= 19){
                                upperLimit = 2800.0
                                adequateIntake = 900.0
                            }
                        }
                    }
                    //Vitamin C
                    dailyNutrientIntake.nutrientIntake[1].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3){
                                upperLimit = 400.0
                                adequateIntake = 15.0
                            }else if (age in 4..8){
                                upperLimit = 650.0
                                adequateIntake = 25.0
                            }else if (age in 9..13){
                                upperLimit = 1200.0
                                adequateIntake = 45.0
                            }else if (age in 14..18){
                                upperLimit = 1800.0
                                adequateIntake = 75.0
                            }else if (age >= 19){
                                upperLimit = 2000.0
                                adequateIntake = 90.0
                            }
                        }
                    }
                    //Vitamin D
                    dailyNutrientIntake.nutrientIntake[2].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake
                            if (age in 1..13) {
                                adequateIntake = 15.0
                            } else if (age in 14..18) {
                                adequateIntake = 15.0
                            } else if (age in 19..50) {
                                adequateIntake = 15.0
                            } else if (age in 51..70) {
                                adequateIntake = 15.0
                            } else if (age >= 19) {
                                adequateIntake = 20.0
                            }
                            //tolerable upper intake level
                            if (age in 1..3) {
                                upperLimit = 63.0
                            } else if (age in 4..8) {
                                upperLimit = 75.0
                            } else if (age >= 9) {
                                upperLimit = 100.0
                            }
                        }
                    }
                    //Calcium
                    dailyNutrientIntake.nutrientIntake[3].nutrient!!.apply {
                        //adequate intake
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3) {
                                adequateIntake = 700.0
                            } else if (age in 4..8 || age in 19..50) {
                                adequateIntake = 1000.0
                            } else if (age in 9..13) {
                                adequateIntake = 1300.0
                            } else if (age in 14..18) {
                                adequateIntake = 1300.0
                            } else if (age in 51..70) {
                                adequateIntake = 1000.0
                            } else if (age >= 70) {
                                adequateIntake = 1200.0
                            }
                            //tolerable upper intake level
                            if (age in 1..8 || age in 19..50) {
                                upperLimit = 2500.0
                            } else if (age in 9..18) {
                                upperLimit = 3000.0
                            } else if (age >= 51) {
                                upperLimit = 2000.0
                            }
                        }
                    }
                    //Potassium
                    dailyNutrientIntake.nutrientIntake[4].nutrient!!.apply {
                        //adequate intake
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3) {
                                adequateIntake = 2000.0
                            } else if (age in 4..8) {
                                adequateIntake = 2300.0
                            } else if (age in 9..13) {
                                adequateIntake = 2500.0
                            } else if (age in 14..18) {
                                adequateIntake = 3000.0
                            } else if (age >= 19) {
                                adequateIntake = 3400.0
                            }
                            //No tolerable upper intake level specified
                        }
                    }
                    //Sodium
                    //Same with female
                    dailyNutrientIntake.nutrientIntake[5].nutrient!!.apply {
                        //adequate intake
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3) {
                                adequateIntake = 800.0
                            } else if (age in 4..8) {
                                adequateIntake = 1000.0
                            } else if (age in 9..13) {
                                adequateIntake = 1200.0
                            } else if (age >= 14) {
                                adequateIntake = 1500.0
                            }
                            //No tolerable upper intake level specified
                        }
                    }
                    //Magnesium
                    dailyNutrientIntake.nutrientIntake[6].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake
                            if (age in 1..3) {
                                adequateIntake = 80.0
                            } else if (age in 4..8) {
                                adequateIntake = 130.0
                            } else if (age in 9..13) {
                                adequateIntake = 240.0
                            } else if (age in 14..18) {
                                adequateIntake = 410.0
                            } else if (age in 19..30) {
                                adequateIntake = 400.0
                            } else if (age >= 31) {
                                adequateIntake = 420.0
                            }
                            //tolerable upper intake level
                            if (age in 1..3) {
                                upperLimit = 63.0
                            } else if (age in 4..8) {
                                upperLimit = 75.0
                            } else if (age >= 9) {
                                upperLimit = 350.0
                            }
                        }
                    }
                    //Iron
                    dailyNutrientIntake.nutrientIntake[7].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake
                            if (age in 1..3) {
                                adequateIntake = 7.0
                            } else if (age in 4..8) {
                                adequateIntake = 10.0
                            } else if (age in 9..13) {
                                adequateIntake = 8.0
                            } else if (age in 14..18) {
                                adequateIntake = 11.0
                            } else if (age >= 19) {
                                adequateIntake = 8.0
                            }
                            //tolerable upper intake level
                            if (age in 1..13) {
                                upperLimit = 40.0
                            } else if (age >= 14) {
                                upperLimit = 45.0
                            }
                        }
                    }
                    //Zinc
                    dailyNutrientIntake.nutrientIntake[8].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake and tolerable upper intake level
                            if (age in 1..3) {
                                upperLimit = 7.0
                                adequateIntake = 3.0
                            } else if (age in 4..8) {
                                upperLimit = 12.0
                                adequateIntake = 5.0
                            } else if (age in 9..13) {
                                upperLimit = 23.0
                                adequateIntake = 8.0
                            } else if (age in 14..18) {
                                upperLimit = 34.0
                                adequateIntake = 11.0
                            } else if (age >= 19) {
                                upperLimit = 40.0
                                adequateIntake = 11.0
                            }
                        }
                    }
                    //Selenium
                    dailyNutrientIntake.nutrientIntake[9].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake and tolerable upper intake level
                            if (age in 1..3) {
                                upperLimit = 90.0
                                adequateIntake = 20.0
                            } else if (age in 4..8) {
                                upperLimit = 150.0
                                adequateIntake = 30.0
                            } else if (age in 9..13) {
                                upperLimit = 280.0
                                adequateIntake = 40.0
                            } else if (age >= 14) {
                                upperLimit = 400.0
                                adequateIntake = 55.0
                            }
                        }
                    }


                }else if (user.sex == "Female"){
                    //Vitamin A
                    dailyNutrientIntake.nutrientIntake[0].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3){
                                upperLimit = 600.0
                                adequateIntake = 300.0
                            }else if (age in 4..8){
                                upperLimit = 900.0
                                adequateIntake = 400.0
                            }else if (age in 9..13){
                                upperLimit = 1700.0
                                adequateIntake = 600.0
                            }else if (age in 14..18){
                                upperLimit = 2800.0
                                adequateIntake = 700.0
                            }else if (age >= 19){
                                upperLimit = 2800.0
                                adequateIntake = 700.0
                            }
                        }
                    }
                    //Vitamin C
                    dailyNutrientIntake.nutrientIntake[1].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3) {
                                upperLimit = 400.0
                                adequateIntake = 15.0
                            } else if (age in 4..8) {
                                upperLimit = 650.0
                                adequateIntake = 25.0
                            } else if (age in 9..13) {
                                upperLimit = 1200.0
                                adequateIntake = 45.0
                            } else if (age in 14..18) {
                                upperLimit = 1800.0
                                adequateIntake = 65.0
                            } else if (age >= 19) {
                                upperLimit = 2000.0
                                adequateIntake = 75.0
                            }
                        }
                    }
                    //Vitamin D
                    dailyNutrientIntake.nutrientIntake[2].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake
                            if (age in 1..13) {
                                adequateIntake = 15.0
                            } else if (age in 14..18) {
                                adequateIntake = 15.0
                            } else if (age in 19..50) {
                                adequateIntake = 15.0
                            } else if (age in 51..70) {
                                adequateIntake = 15.0
                            } else if (age >= 19) {
                                adequateIntake = 20.0
                            }
                            //tolerable upper intake level
                            if (age in 1..3) {
                                upperLimit = 63.0
                            } else if (age in 4..8) {
                                upperLimit = 75.0
                            } else if (age >= 9) {
                                upperLimit = 100.0
                            }
                        }
                    }
                    //Calcium
                    dailyNutrientIntake.nutrientIntake[3].nutrient!!.apply {
                        //adequate intake
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3) {
                                adequateIntake = 700.0
                            } else if (age in 4..8 || age in 19..50) {
                                adequateIntake = 1000.0
                            } else if (age in 9..13) {
                                adequateIntake = 1300.0
                            } else if (age in 14..18) {
                                adequateIntake = 1300.0
                            } else if (age >= 51) {
                                adequateIntake = 1200.0
                            }
                            //tolerable upper intake level
                            if (age in 1..8 || age in 19..50) {
                                upperLimit = 2500.0
                            } else if (age in 9..18) {
                                upperLimit = 3000.0
                            } else if (age >= 51) {
                                upperLimit = 2000.0
                            }
                        }
                    }
                    //Potassium
                    dailyNutrientIntake.nutrientIntake[4].nutrient!!.apply {
                        //adequate intake
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3) {
                                adequateIntake = 2000.0
                            } else if (age in 4..18) {
                                adequateIntake = 2300.0
                            } else if (age >= 19) {
                                adequateIntake = 2600.0
                            }
                            //No tolerable upper intake level specified
                        }
                    }
                    //Sodium
                    //Same with male
                    dailyNutrientIntake.nutrientIntake[5].nutrient!!.apply {
                        //adequate intake
                        recommendedDietaryIntake = RDA().apply {
                            if (age in 1..3) {
                                adequateIntake = 800.0
                            } else if (age in 4..8) {
                                adequateIntake = 1000.0
                            } else if (age in 9..13) {
                                adequateIntake = 1200.0
                            } else if (age >= 14) {
                                adequateIntake = 1500.0
                            }
                            //No tolerable upper intake level specified
                        }
                    }
                    //Magnesium
                    dailyNutrientIntake.nutrientIntake[6].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake
                            if (age in 1..3) {
                                adequateIntake = 80.0
                            } else if (age in 4..8) {
                                adequateIntake = 130.0
                            } else if (age in 9..13) {
                                adequateIntake = 240.0
                            } else if (age in 14..18) {
                                adequateIntake = 360.0
                            } else if (age in 19..30) {
                                adequateIntake = 310.0
                            } else if (age >= 31) {
                                adequateIntake = 320.0
                            }
                            //tolerable upper intake level
                            if (age in 1..3) {
                                upperLimit = 63.0
                            } else if (age in 4..8) {
                                upperLimit = 75.0
                            } else if (age >= 9) {
                                upperLimit = 350.0
                            }
                        }
                    }
                    //Iron
                    dailyNutrientIntake.nutrientIntake[7].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake
                            if (age in 1..3) {
                                adequateIntake = 7.0
                            } else if (age in 4..8) {
                                adequateIntake = 10.0
                            } else if (age in 9..13) {
                                adequateIntake = 8.0
                            } else if (age in 14..18) {
                                adequateIntake = 15.0
                            } else if (age in 19..50) {
                                adequateIntake = 18.0
                            } else if (age >= 51) {
                                adequateIntake = 8.0
                            }
                            //tolerable upper intake level
                            if (age in 1..13) {
                                upperLimit = 40.0
                            } else if (age >= 14) {
                                upperLimit = 45.0
                            }
                        }
                    }
                    //Zinc
                    dailyNutrientIntake.nutrientIntake[8].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake and tolerable upper intake level
                            if (age in 1..3) {
                                upperLimit = 7.0
                                adequateIntake = 3.0
                            } else if (age in 4..8) {
                                upperLimit = 12.0
                                adequateIntake = 5.0
                            } else if (age in 9..13) {
                                upperLimit = 23.0
                                adequateIntake = 8.0
                            } else if (age in 14..18) {
                                upperLimit = 34.0
                                adequateIntake = 9.0
                            } else if (age >= 19) {
                                upperLimit = 40.0
                                adequateIntake = 8.0
                            }
                        }
                    }
                    //Selenium
                    dailyNutrientIntake.nutrientIntake[9].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            //adequateIntake and tolerable upper intake level
                            if (age in 1..3) {
                                upperLimit = 90.0
                                adequateIntake = 20.0
                            } else if (age in 4..8) {
                                upperLimit = 150.0
                                adequateIntake = 30.0
                            } else if (age in 9..13) {
                                upperLimit = 280.0
                                adequateIntake = 40.0
                            } else if (age >= 14) {
                                upperLimit = 400.0
                                adequateIntake = 55.0
                            }
                        }
                    }
                    //Calories
                    //creates another object `NutrientContent` to dailyNutrientIntake's list, and fetches its upperLimit right after
                    val calorieAL = dailyNutrientIntake.nutrientIntake[10].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {

                            if (user.goal!!.goal == "Lose Weight"){
                                upperLimit = (665 + (9.6 * user.goal!!.currentWeight) + (1.8 * user.height) - (4.7 * age)) * user.activityLevel * 0.80
                            }else if (user.goal!!.goal == "Gain Weight"){
                                upperLimit = (665 + (9.6 * user.goal!!.currentWeight) + (1.8 * user.height) - (4.7 * age)) * user.activityLevel + 250
                            }else if (user.goal!!.goal == "Maintain Weight"){
                                upperLimit = (665 + (9.6 * user.goal!!.currentWeight) + (1.8 * user.height) - (4.7 * age))
                            }

                        }
                    }.recommendedDietaryIntake!!.upperLimit
                    //store to variable since it'll be frequently accessed
                    //Total Fat
                    dailyNutrientIntake.nutrientIntake[11].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            upperLimit = 0.3 * calorieAL
                        }
                    }
                    //Saturated Fat
                    dailyNutrientIntake.nutrientIntake[12].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            upperLimit = 0.03 * calorieAL
                        }
                    }
                    //Monounsaturated Fat
                    dailyNutrientIntake.nutrientIntake[13].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            upperLimit = 0.3 * calorieAL
                            adequateIntake = 0.3 * calorieAL
                        }
                    }
                    //Polyunsaturated Fat
                    dailyNutrientIntake.nutrientIntake[13].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            upperLimit = 0.3 * calorieAL
                            adequateIntake = 0.3 * calorieAL
                        }
                    }
                    //Trans Fat
                    dailyNutrientIntake.nutrientIntake[13].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            upperLimit = 0.003 * calorieAL
                        }
                    }
                    //Cholesterol
                    dailyNutrientIntake.nutrientIntake[13].nutrient!!.apply {
                        recommendedDietaryIntake = RDA().apply {
                            upperLimit = 0.003 * calorieAL
                        }
                    }

                }
            }
            .build()
        realm = Realm.open(config)

    }

    override fun onTerminate() {
        super.onTerminate()
        realm.close() // Close the Realm instance when the app terminates
    }

}