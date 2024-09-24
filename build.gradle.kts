// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("io.realm.kotlin") version "1.11.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}

// Project-level build.gradle.kts file

buildscript {
    repositories {
        
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2") // Use Kotlin DSL syntax for the classpath
        val nav_version = "2.7.7"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}

allprojects {
    repositories {

    }
}
