plugins {
    id("org.jetbrains.kotlin.jvm")
    `java-library`
}

dependencies {
    api(project(":domain"))
    implementation("javax.inject:javax.inject:1")
    implementation("javax.transaction:javax.transaction-api:1.3")
}
