//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    java
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
}

//jacoco {
//    toolVersion = "0.8.7"
//}
//
//tasks.withType<KotlinCompile>() {
//    kotlinOptions.jvmTarget = "1.8"
//}
//
//tasks.test {
//    useJUnitPlatform()
//    finalizedBy(tasks.jacocoTestReport)
//
//    configure<JacocoTaskExtension> {
//        isEnabled = true
//        includes = listOf("src/test/groovy")
//        excludes = emptyList()
//    }
//}
//
//tasks.jacocoTestReport {
//    dependsOn(tasks.test)
//
//    reports {
//        xml.required.set(false)
//        csv.required.set(false)
//        html.required.set(true)
//    }
//}
//
//tasks.jacocoTestCoverageVerification {
//    violationRules {
//        rule {
//            element = "PACKAGE"
//
//            limit {
//                counter = "CLASS"
//                value = "MISSEDCOUNT"
//                minimum = "0".toBigDecimal()
//            }
//
//            limit {
//                counter = "INSTRUCTION"
//                value = "COVEREDRATIO"
//                minimum = "1.0".toBigDecimal()
//            }
//
//            limit {
//                counter = "COMPLEXITY"
//                value = "COVEREDRATIO"
//                minimum = "1.0".toBigDecimal()
//            }
//        }
//    }
//}