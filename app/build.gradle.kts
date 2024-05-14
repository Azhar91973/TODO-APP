plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id ("kotlin-android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.todoapp"
    compileSdk = 34

    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig {
        applicationId = "com.example.todoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures{
        viewBinding = true
    }

} 
dependencies{
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("androidx.activity:activity-ktx:1.4.0")

    // Room components
    implementation ("androidx.room:room-runtime:2.4.1")
    annotationProcessor ("androidx.room:room-compiler:2.4.1")

    // Lifecycle components
    implementation ("androidx.room:room-ktx:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")

    // ViewModel and LiveData
    val arch_version = "2.2.0"
    implementation ("androidx.lifecycle:lifecycle-extensions:$arch_version")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$arch_version")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$arch_version")

    // Kotlin components
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.6.10")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")

    // UI
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation ("com.google.android.material:material:1.5.0")

    // Testing
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")

}