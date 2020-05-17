plugins {
    kotlin("jvm")
    `java-library`
    id("org.springframework.boot") version "2.2.6.RELEASE" apply (false)
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("plugin.spring") version "1.3.72"
}

dependencies {
    implementation(project(":interaction"))

    implementation("org.springframework.boot:spring-boot-starter-web:2.2.6.RELEASE")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.0")
}
