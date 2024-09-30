package com.example.softwareengineeringproject.db.user

//import com.example.softwareengineeringproject.db.diary.Diary
//import io.realm.kotlin.ext.realmListOf
//import io.realm.kotlin.types.RealmInstant
//import io.realm.kotlin.types.RealmList
//import io.realm.kotlin.types.RealmObject
//import io.realm.kotlin.types.annotations.Ignore
//import io.realm.kotlin.types.annotations.PrimaryKey
//import org.mongodb.kbson.ObjectId
//import java.util.Date

//class User: RealmObject {
//
//    @PrimaryKey
//    var _id: ObjectId = ObjectId()
//    var firstName: String = ""
//    var profileImg: String = ""
//    //@Ignore
//    /*
//        e: file:///C:/Users/ACER/AndroidStudioProjects/SoftwareEngineeringProject/app/src/main/java/com/example/softwareengineeringproject/db/food/SampleFood.kt:10:5
//        [Realm] Realm does not support persisting properties of this type.
//        Mark the field with `@Ignore` to suppress this error.
//        Date() from java.util is not supported by Realm-Kotlin sdk
//     */
//    var birthDate: RealmInstant = RealmInstant.now()
//    var nutrientIntakeHistory: NutrientIntakeHistory = NutrientIntakeHistory()
//    var goal: Goal = Goal()
//    var activityLevel: Int = 0
//    var sex: String = ""
//
//    /*
//        Use a strong and secure hashing algorithm like bcrypt, Argon2, or PBKDF2.
//        These algorithms are designed specifically for hashing passwords and include features to mitigate brute-force attacks.
//     */
//
//    var password: String = "" //must be hashed
//
//    /*
//        A salt is a random value added to the password before hashing.
//        It ensures that even if two users have the same password, their hashed values will be different.
//        Store the salt alongside the hashed password.
//     */
//
//    var salt: String = ""
//    var diary: Diary = Diary()
//
//}