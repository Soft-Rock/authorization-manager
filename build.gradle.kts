// PLUGINS -- BEGIN
plugins {
    kotlin("jvm") version "1.3.72"
    id("com.jfrog.bintray") version "1.8.5"
    `maven-publish`
    id("com.diffplug.gradle.spotless") version "3.28.1"
}

allprojects {
    apply(plugin = "kotlin")
    java.sourceCompatibility = JavaVersion.VERSION_1_8
}
// PLUGINS -- END

// spotless configuration -- BEGIN
allprojects {
    apply(plugin = "com.diffplug.gradle.spotless")

    spotless {
        kotlin {
            ktlint()
        }
        kotlinGradle {
            ktlint()
        }
    }

    listOf(tasks.compileJava, tasks.compileKotlin, tasks.compileTestJava, tasks.compileTestKotlin).forEach {
        it.get().mustRunAfter(tasks.spotlessCheck)
    }

    tasks.check {
        dependsOn(tasks.spotlessCheck)
    }
}
// spotless configuration -- END

// SOURCES -- BEGIN
java {
    withSourcesJar()
}
// SOURCES -- END

// JAVADOC -- BEGIN
java {
    withJavadocJar()
}
// JAVADOC -- END

// TEST LOGGING -- BEGIN
allprojects {
    tasks.withType<Test> {
        testLogging {
            showStandardStreams = false
            events("skipped", "failed")
            showExceptions = true
            showCauses = true
            showStackTraces = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
        afterSuite(printTestResult)
    }
}

val printTestResult: KotlinClosure2<TestDescriptor, TestResult, Void>
    get() = KotlinClosure2({ desc, result ->

        if (desc.parent == null) { // will match the outermost suite
            println("------")
            println(
                    "Results: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} " +
                            "successes, ${result.failedTestCount} failures, ${result.skippedTestCount} skipped)"
            )
            println(
                    "Tests took: ${result.endTime - result.startTime} ms."
            )
            println("------")
        }
        null
    })
// TEST LOGGING -- END

// JUNIT -- BEGIN
allprojects {
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
// JUNIT -- END

// Dependencies -- BEGIN
allprojects {
    repositories {
        jcenter()
    }

    dependencies {
        "implementation"(platform(kotlin("bom")))
        "implementation"(kotlin("stdlib-jdk8"))

        "testImplementation"("org.junit.jupiter:junit-jupiter-api:5.6.2")
        "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:5.6.2")
        "testImplementation"("io.mockk:mockk:1.10.0")
        "testImplementation"("org.assertj:assertj-core:3.15.0")
    }
}
// Dependencies -- END

// Publishing -- BEGIN
val mavenPublicationName: String = "maven"

publishing {
    publications {
        create<MavenPublication>(mavenPublicationName) {
            groupId = "com.davidgracia.software"
            artifactId = "authorization-manager"
            version = project.version.toString()

            from(components["java"])
            pom {
                name.set("Authorization manager")
                description.set("A concise description of my library")
                url.set("https://github.com/beforeigners/authorization-manager")
                licenses {
                    license {
                        name.set("The MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("dgraciac")
                        name.set("David Gracia Celemendi")
                        email.set("david.gracia.celemendi@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/beforeigners/authorization-manager.git")
                    developerConnection.set("scm:git:ssh://github.com/beforeigners/authorization-manager.git")
                    url.set("https://github.com/beforeigners/authorization-manager")
                }
            }
        }
    }
}

bintray {
    user = System.getProperty("bintray.user")
    key = System.getProperty("bintray.key")
    setPublications(mavenPublicationName)
    publish = true
    pkg.apply {
        repo = "maven"
        name = "authorization-manager"
        userOrg = "beforeigners"
        vcsUrl = "https://github.com/beforeigners/authorization-manager"
        version.apply {
            name = project.version.toString()
        }
    }
}
// Publishing -- END
