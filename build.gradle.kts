//PLUGINS -- BEGIN
plugins {
    kotlin("jvm") version "1.3.72"
    id("com.jfrog.bintray") version "1.8.5"
    `maven-publish`
}

allprojects {
    apply(plugin = "kotlin")
    java.sourceCompatibility = JavaVersion.VERSION_1_8
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
        "implementation"(platform(kotlin("bom")))
        "implementation"(kotlin("stdlib-jdk8"))
        "testImplementation"(kotlin("test"))
        "testImplementation"(kotlin("test-junit"))
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
                url.set("https://github.com/beforeigners/authorization-manager")
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
                    connection.set("scm:git:git://github.com/beforeigners/authorization-manager.git")
                    developerConnection.set("scm:git:ssh://github.com/beforeigners/authorization-manager.git")
                    url.set("https://github.com/beforeigners/authorization-manager")
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
        userOrg = "beforeigners"
        vcsUrl = "https://github.com/beforeigners/authorization-manager"
        version.apply {
            name = project.version.toString()
        }
    }
}
//Publishing -- END