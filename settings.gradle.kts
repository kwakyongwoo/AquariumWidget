pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AquariumWidget"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:common")
include(":core:datastore-proto")
include(":core:datastore")
include(":core:model")
include(":core:datastore-test")
include(":core:database")
include(":core:testing")
include(":core:data")
include(":core:designsystem")
include(":feature:splash")
include(":feature:home")
include(":core:ui")
include(":feature:fishing")
include(":feature:collection")
include(":feature:item")
