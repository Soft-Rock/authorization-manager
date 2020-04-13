//PLUGINS -- BEGIN
plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    id("com.jfrog.bintray") version "1.8.5"
    `maven-publish`
}

allprojects {
    apply(plugin = "kotlin")
}
//PLUGINS -- END

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

//Dependencies -- BEGIN
allprojects {
    repositories {
        jcenter()
    }

    dependencies {
        "implementation"(platform("org.jetbrains.kotlin:kotlin-bom"))
        "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        "testImplementation"("org.jetbrains.kotlin:kotlin-test")
        "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit")
    }
}
//Dependencies -- END

//Publishing -- BEGIN
val mavenPublicationName: String = "maven"

publishing {
    publications {
        create<MavenPublication>(mavenPublicationName) {
            groupId = "com.davidgracia.software"
            artifactId = "authorization-manager"
            version = project.version.toString()

            from(components["java"])
            pom {
                name.set("Authorization manager")
                description.set("A concise description of my library")
                url.set("https://github.com/Soft-Rock/authorization-manager")
                licenses {
                    license {
                        name.set("The MIT License")
                        url.set("https://opensource.org/licenses/MIT")
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
        userOrg = "soft-rock"
        vcsUrl = "https://github.com/Soft-Rock/authorization-manager"
        version.apply {
            name = project.version.toString()
        }
    }
}
//Publishing -- END