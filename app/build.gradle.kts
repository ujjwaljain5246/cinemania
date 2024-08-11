plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.google.devtools.ksp")
  id ("kotlin-parcelize")
  id ("androidx.navigation.safeargs.kotlin")
}

android {
  namespace = "com.example.timepass"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.timepass"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.1"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
  implementation("androidx.activity:activity-compose:1.8.2")
  implementation(platform("androidx.compose:compose-bom:2023.08.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
  implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

  implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.20") // Include Kotlin stdlib

  // Navigation Component
  implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
  implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")

  // Lifecycle components
  implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
  implementation ("androidx.lifecycle:lifecycle-common-java8:2.7.0")
  implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

  // Adding dependencies related to retrofit and Gson converter
  implementation ("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit library for making HTTP requests
  implementation ("com.squareup.retrofit2:converter-gson:2.9.0") // Gson converter for Retrofit, to serialize and deserialize JSON

  // Adding dependencies related to coroutine
  implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1") // This provides the core functionality for working with coroutines.
  implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1") // This provides additional support for using coroutines in Android applications, including integration with the Android lifecycle.

  // Adding dependencies related to load image from various sources
  implementation ("com.github.bumptech.glide:glide:4.12.0") // Glide library for loading and caching images from various sources
  annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0") // Annotation processor for Glide to generate Glide API code during compilation

  // Dependencies for glide
  implementation ("com.github.bumptech.glide:glide:4.12.0")
  annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

  // Dependency for youtube android player
  implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0")

  // Dependencies for lifecycle of ViewModel
  // ViewModel
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")
}