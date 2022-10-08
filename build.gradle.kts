plugins {
    kotlin("jvm") version "1.7.20"
    groovy
}

group = "com.icosahedron"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
//    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.11") // 3.0.0
    implementation("ch.qos.logback:logback-classic:1.2.11") // 1.4.3
    implementation("com.google.code.gson:gson:2.9.1")

    testImplementation("org.spockframework:spock-core:2.2-groovy-4.0")
}
