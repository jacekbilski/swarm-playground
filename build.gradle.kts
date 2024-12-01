plugins {
    id("org.springframework.boot") version "3.4.0" apply false
    id("io.spring.dependency-management") version "1.1.6"
    java
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    version = "0.0.1-SNAPSHOT"

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    repositories {
        mavenCentral()
    }
}
