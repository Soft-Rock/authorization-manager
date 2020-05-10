plugins {
    kotlin("jvm")
    `java-library`
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("plugin.spring") version "1.3.72"
}

tasks.bootJar {
    enabled = false
}

dependencies {
    implementation(project(":interaction"))

    // implementation("org.hibernate:hibernate-validator:4.2.0.Final")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}
