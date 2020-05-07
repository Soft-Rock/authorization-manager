plugins {
    kotlin("jvm")
    `java-library`
}

dependencies {
    implementation(project(":interaction"))

    "testImplementation"("org.junit.jupiter:junit-jupiter-api:5.6.2")
    "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:5.6.2")
    "testImplementation"("io.mockk:mockk:1.10.0")
    "testImplementation"("org.assertj:assertj-core:3.15.0")
    "testImplementation"("org.amshove.kluent:kluent:1.61")
}