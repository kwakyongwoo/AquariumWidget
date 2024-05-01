plugins {
    alias(libs.plugins.aquarium.android.application)
    alias(libs.plugins.aquarium.android.application.compose)
    alias(libs.plugins.aquarium.android.application.jacoco)
    alias(libs.plugins.aquarium.android.hilt)
    id("jacoco")
}

android {
    namespace = "com.dyddyd.aquariumwidget"

    defaultConfig {
        applicationId = "com.dyddyd.aquariumwidget"
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.feature.splash)
    implementation(projects.feature.home)

    implementation(projects.core.common)
//    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    implementation(projects.core.model)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)

    debugImplementation(libs.androidx.compose.ui.testManifest)

    kspTest(libs.hilt.compiler)

    testImplementation(projects.core.testing)
    testImplementation(libs.accompanist.testharness)
    testImplementation(libs.work.testing)

    androidTestImplementation(projects.core.testing)
    androidTestImplementation(projects.core.datastoreTest)
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.accompanist.testharness)
    androidTestImplementation(libs.hilt.android.testing)
}