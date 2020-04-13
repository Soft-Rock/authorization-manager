plugins {
    id("org.jetbrains.kotlin.jvm")
    `java-library`
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":interaction"))
}