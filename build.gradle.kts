plugins {
    kotlin("jvm") version "1.7.10"
    java
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
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.10")
//    implementation("org.jetbrains.kotlin:kotlinx-coroutines-core-jvm:1.6.4")
//    implementation("org.jetbrains.kotlin:kotlinx-coroutines-jdk8:1.6.0")
    testImplementation("org.spockframework:spock-core:2.2-groovy-4.0")
}
