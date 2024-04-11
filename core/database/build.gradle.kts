plugins {
    alias(libs.plugins.aquarium.android.library)
    alias(libs.plugins.aquarium.android.library.jacoco)
    alias(libs.plugins.aquarium.android.hilt)
    alias(libs.plugins.aquarium.android.room)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.dyddyd.aquariumwidget.core.database"
}

dependencies {
    api(projects.core.model)

    implementation(libs.kotlinx.datetime)

    androidTestImplementation(projects.core.testing)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    implementation(libs.androidx.test.rules)
}