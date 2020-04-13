plugins {
    id("org.jetbrains.kotlin.jvm")
    `java-library`
}

dependencies {
    implementation(project(":domain"))
}