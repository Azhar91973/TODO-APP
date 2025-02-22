plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.todoapp"
    compileSdk = 35

    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig {
        applicationId = "com.example.todoapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}
dependencies {
    implementation(libs.androidx.appcompat)
    implementation("androidx.activity:activity-ktx:1.10.0")

    // Room components
    implementation("androidx.room:room-runtime:2.6.1")
    implementation(libs.androidx.databinding.runtime)
    implementation(libs.androidx.activity)
    annotationProcessor("androidx.room:room-compiler:2.6.1")

    // Lifecycle components
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    // ViewModel and LiveData
    val arch_version = "2.2.0"
    implementation("androidx.lifecycle:lifecycle-extensions:$arch_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$arch_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$arch_version")

    // Kotlin components
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.20")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // UI
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

}