import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
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