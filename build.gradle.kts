plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    `java-library`
    id("com.jfrog.bintray") version "1.8.5"
    `maven-publish`
}

//SOURCES -- BEGIN
java {
    withSourcesJar()
}
//SOURCES -- END

//JAVADOC -- BEGIN
/*tasks.javadoc {
    isFailOnError = false
}*/

java {
    withJavadocJar()
}
//JAVADOC -- END

/*tasks.withType<AbstractArchiveTask> {
    setProperty("archiveBaseName", "booking-service")
    setProperty("archiveAppendix", "secondary-adapter-goto")
    setProperty("archiveVersion", "1.0.0")
    setProperty("archiveClassifier", "")
    setProperty("archiveExtension", "jar")
}*/

val mavenPublicationName: String = "maven"

publishing {
    publications {
        create<MavenPublication>(mavenPublicationName) {
            groupId = "com.davidgracia.software"
            artifactId = "authorization-manager"
            version = "0.0.1"

            from(components["java"])
            pom {
                name.set("Authorization manager")
                description.set("A concise description of my library")
                url.set("http://www.example.com/library")
                licenses {
                    license {
                        name.set("GNU General Public License v3.0")
                        url.set("https://www.gnu.org/licenses/gpl-3.0.html")
                    }
                }
                developers {
                    developer {
                        id.set("dgraciac")
                        name.set("David Gracia Celemendi")
                        email.set("david.gracia.celemendi@gmail.com")
                    }
                }
                scm {
//                    connection.set("scm:git:git://example.com/my-library.git")
//                    developerConnection.set("scm:git:ssh://example.com/my-library.git")
                    url.set("https://github.com/Soft-Rock/authorization-manager")
                }
            }
        }
    }
}


fun findProperty(s: String) = project.findProperty(s) as String?
bintray {
    user = findProperty("bintray.user")
    key = findProperty("bintray.key")
    setPublications(mavenPublicationName)
//        publish = true
    pkg(delegateClosureOf<com.jfrog.bintray.gradle.BintrayExtension.PackageConfig> {
        repo = "authorization-manager"
        name = "authorization-manager"
        userOrg = "dgraciac"

        setLicenses("GNU General Public License v3.0")
        vcsUrl = "https://github.com/Soft-Rock/authorization-manager"
/*        version {
            name = "1.0.0"
            desc = "1.0.0"
            released = java.util.Date()
        }*/
    })
}

repositories {
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
