plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.deanuharatinu.feature.pokemonlist"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":common"))

    implementation(libs.core.androidx.ktx)
    implementation(libs.core.appcompat)
    implementation(libs.core.material)
    implementation(libs.core.constraintlayout)
    implementation(libs.core.lifecycle.livedata.ktx)
    implementation(libs.core.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    testImplementation(libs.test.junit)
    testImplementation(libs.test.mock.web.server)
    testImplementation(libs.test.mock.core)
    testImplementation(libs.test.turbine)
    testImplementation(libs.test.mockito.kotlin)
    testImplementation(libs.test.mockito.inline)
    androidTestImplementation(libs.android.test.ext.junit)
    androidTestImplementation(libs.android.test.espresso.core)
}