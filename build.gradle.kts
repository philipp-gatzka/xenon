plugins {
    id("java-library")
    id("maven-publish")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withJavadocJar()
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.0.1")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name.set("xenon")
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "philipp-gatzka"
                        name = "Philipp Gatzka"
                        email = "phil.gatzka@gmail.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/philipp-gatzka/xenon.git"
                    developerConnection = "scm:git:ssh://github.com/philipp-gatzka/xenon.git"
                    url = "https://github.com/philipp-gatzka/xenon"
                }
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/philipp-gatzka/xenon")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("PASSWORD")
            }
        }
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}