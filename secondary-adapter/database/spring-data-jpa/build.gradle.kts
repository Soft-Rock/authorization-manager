plugins {
    kotlin("jvm")
    `java-library`
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
}

tasks.bootJar {
    enabled = false
}

dependencies {
    implementation(project(":interaction"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2:1.4.200")
}
