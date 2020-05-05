plugins {
    kotlin("jvm")
    `java-library`
}

dependencies {
    api(project(":domain"))
    implementation("javax.transaction:javax.transaction-api:1.3")
}
