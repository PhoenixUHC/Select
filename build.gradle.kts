plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.phoenix.select"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    implementation(project(":api"))
}

tasks {
    jar {
        enabled = false
    }
    build {
        dependsOn(shadowJar)
    }
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}
