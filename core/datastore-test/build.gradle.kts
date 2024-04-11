plugins {
    alias(libs.plugins.aquarium.android.library)
    alias(libs.plugins.aquarium.android.hilt)
}

android {
    namespace = "com.dyddyd.aquariumwidget.core.datastore.test"
}

dependencies {
    implementation(libs.hilt.android.testing)
    implementation(projects.core.common)
    implementation(projects.core.datastore)
}