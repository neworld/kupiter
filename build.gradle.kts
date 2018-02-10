val kotlinVersion = "1.2.21"
val jupiterVersion = "5.0.3"

plugins {
    kotlin("jvm") version "1.2.21"
    id("org.junit.platform.gradle.plugin")
    maven
}

group = "lt.neworld"
version = "1.0.0"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$jupiterVersion")

}

val sourcesJar by tasks.creating(Jar::class) {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    classifier = "sources"
    from(java.sourceSets["main"].allSource)
}

val archives = configurations.getByName("archives")

artifacts.add(archives.name, sourcesJar) {
    builtBy(sourcesJar)
}
