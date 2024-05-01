plugins {
    alias(libs.plugins.aquarium.android.feature)
    alias(libs.plugins.aquarium.android.library.compose)
    alias(libs.plugins.aquarium.android.library.jacoco)
}

android {
    namespace = "com.dyddyd.aquariumwidget.feature.splash"
}

dependencies {
    implementation(libs.accompanist.permissions)
    implementation(projects.core.data)
//    implementation(projects.core.domain)

    testImplementation(libs.hilt.android.testing)
//    testImplementation(libs.robolectric)
//    testImplementation(projects.core.testing)

//    androidTestImplementation(projects.core.testing)
}