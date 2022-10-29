plugins {
    kotlin("jvm") version "1.7.20"
    groovy
    jacoco
}

group = "com.icosahedron"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("com.google.code.gson:gson:2.9.1")

    @Suppress("GradlePackageUpdate")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")

    @Suppress("GradlePackageUpdate")
    implementation("ch.qos.logback:logback-classic:1.2.11")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.20")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.1")
    testImplementation("org.spockframework:spock-core:2.3-groovy-4.0")
}

jacoco {
    toolVersion = "0.8.8"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

val jacocoClassDirectories =
tasks.jacocoTestReport {
    finalizedBy(tasks.jacocoTestCoverageVerification)

    classDirectories.setFrom(
        files(classDirectories.files.map {
            fileTree(it) {
                exclude(
                    "com/icosahedron/example/*.class",
                    "com/icosahedron/stub/*.class",
                    "com/icosahedron/core/*.class",
                    "com/icosahedron/math/*.class",
                )
            }
        })
    )
}

tasks.jacocoTestCoverageVerification {
    classDirectories.setFrom(tasks.jacocoTestReport.get().classDirectories)

    violationRules {
        rule {
            isEnabled = true
            element = "PACKAGE"

            limit {
                counter = "INSTRUCTION"
                value = "COVEREDRATIO"
                minimum = "1.0".toBigDecimal()
            }

            limit {
                counter = "COMPLEXITY"
                value = "COVEREDRATIO"
                minimum = "1.0".toBigDecimal()
            }

            limit {
                counter = "CLASS"
                value = "MISSEDCOUNT"
                minimum = "0.0".toBigDecimal()
            }
        }
    }
}
