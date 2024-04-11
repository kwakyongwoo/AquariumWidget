plugins {
    alias(libs.plugins.aquarium.android.library)
    alias(libs.plugins.aquarium.android.library.jacoco)
    alias(libs.plugins.aquarium.android.hilt)
}

android {
    namespace = "com.dyddyd.aquariumwidget.core.common"
}

dependencies {
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}