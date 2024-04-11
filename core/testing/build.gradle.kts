plugins {
    alias(libs.plugins.aquarium.android.library)
    alias(libs.plugins.aquarium.android.library.compose)
    alias(libs.plugins.aquarium.android.hilt)
}

android {
    namespace = "com.dyddyd.aquariumwidget.core.testing"
}

dependencies {
    api(kotlin("test"))
    api(libs.androidx.compose.ui.test)
    api(libs.roborazzi)
//    api(projects.core.data)
    api(projects.core.model)

    debugApi(libs.androidx.compose.ui.testManifest)

    implementation(libs.accompanist.testharness)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.kotlinx.datetime)
    implementation(libs.robolectric.shadows)
    implementation(projects.core.common)
}
