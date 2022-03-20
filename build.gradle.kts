plugins {
    kotlin("jvm") version "1.6.10"
//    groovy
//    java
//    jacoco
}

group = "com.icosahedron"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.10")
    implementation("ch.qos.logback:logback-core:1.2.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.spockframework:spock-core:2.0-M3-groovy-3.0")
}
