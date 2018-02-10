pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.junit.platform.gradle.plugin")) {
                useModule("org.junit.platform:junit-platform-gradle-plugin:1.0.3")
            }
        }
    }
}
