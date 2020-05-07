plugins {
    kotlin("jvm")
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("plugin.spring") version "1.3.72"
}

// CONTAINER TEST CONFIGURATION -- BEGIN
val containerTestName: String = "containerTest"
val containerTestSourceSetName: String = "containerTest"

sourceSets {
    create(containerTestSourceSetName) {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

val containerTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.implementation.get())
}

val containerTestRuntimeOnlyConfigurationName: String = "containerTestRuntimeOnly"
val containerTestRuntimeOnly: Configuration =
        configurations[containerTestRuntimeOnlyConfigurationName].extendsFrom(configurations.runtimeOnly.get())

val containerTest: Test = task<Test>(containerTestName) {
    description = "Runs container tests."
    group = "verification"
    testClassesDirs = sourceSets[containerTestSourceSetName].output.classesDirs
    classpath = sourceSets[containerTestSourceSetName].runtimeClasspath
    shouldRunAfter(tasks.test)
}

tasks.check { dependsOn(containerTest) }

dependencies {
    containerTestImplementation("io.rest-assured:rest-assured:4.2.0")
    containerTestImplementation("io.rest-assured:json-path:4.2.0")
    containerTestImplementation("io.rest-assured:xml-path:4.2.0")
    containerTestImplementation("io.rest-assured:kotlin-extensions:4.2.0")
    containerTestImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(group = "io.rest-assured", module = "rest-assured")
    }
    containerTestImplementation("org.springframework:spring-web")

    containerTestImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    containerTestRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
}
// CONTAINER TEST CONFIGURATION -- END

dependencies {
    implementation(project(":primary-adapter:rest:spring-webmvc"))
    implementation(project(":secondary-adapter:database:spring-data-jpa"))

    implementation("org.springframework.boot:spring-boot-autoconfigure")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
}
