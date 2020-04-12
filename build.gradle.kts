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
java {
    withJavadocJar()
}
//JAVADOC -- END

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
                url.set("https://github.com/Soft-Rock/authorization-manager")
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
                    connection.set("scm:git:git://github.com/Soft-Rock/authorization-manager.git")
                    developerConnection.set("scm:git:ssh://github.com/Soft-Rock/authorization-manager.git")
                    url.set("https://github.com/Soft-Rock/authorization-manager")
                }
            }
        }
    }
}

bintray {
    user = System.getProperty("bintray.user")
    key = System.getProperty("bintray.key")
    setPublications(mavenPublicationName)
    publish = true
    pkg.apply {
        repo = "maven"
        name = "authorization-manager"
        userOrg = "dgraciac"
        vcsUrl = "https://github.com/Soft-Rock/authorization-manager"
        version.apply {
            name = "0.0.1"
        }
    }
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
