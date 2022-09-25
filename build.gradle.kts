plugins {
    kotlin("jvm") version "1.7.10"
    groovy
}

group = "com.icosahedron"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("com.google.code.gson:gson:2.9.1")
    testImplementation("org.spockframework:spock-core:2.2-groovy-4.0")
}
