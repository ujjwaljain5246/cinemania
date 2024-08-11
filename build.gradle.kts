// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  id("com.android.application") version "8.2.1" apply false
  id("org.jetbrains.kotlin.android") version "1.9.0" apply false
  id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}


buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath ("com.android.tools.build:gradle:7.0.4") // Use the latest version
    classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21") // Use the latest version
    classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7") // Use the latest version
  }
}