import java.io.File
import java.util.Properties
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.javaproj"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.javaproj"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        val localProperties = Properties()
        localProperties.load(File(rootDir, "local.properties").inputStream())
        buildConfigField("String", "OPENAI_API_KEY", localProperties["OPENAI_API_KEY"].toString())

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation (libs.okhttp)
    implementation (libs.gson)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}