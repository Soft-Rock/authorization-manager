plugins {
    kotlin("jvm")
    `java-library`
    id("org.springframework.boot") version "2.2.6.RELEASE" apply(false)
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
}

dependencies {
    implementation(project(":interaction"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.6.RELEASE")
    runtimeOnly("com.h2database:h2:1.4.200")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.2.6.RELEASE") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}
