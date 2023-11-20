plugins {
    java
    id("java-library")
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "pete.eremeykin"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

extra["springCloudVersion"] = "2022.0.4"

allprojects {
    apply {
        plugin("java")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("me.paulschwarz:spring-dotenv:4.0.0")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        runtimeOnly("org.postgresql:postgresql")
        implementation("org.flywaydb:flyway-core")
    }

    project.the<SourceSetContainer>()["main"].resources {
        srcDirs(rootProject.file("common/"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }
}

project(":service-api") {
    apply {
        plugin("java-library")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    dependencies {
        api("org.springframework.cloud:spring-cloud-starter-openfeign")
    }
}

project(":http-service") {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
        implementation(project(":service-api"))
    }
}

project(":client-app") {
    dependencies {
        implementation(project(":service-api"))
        implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
        implementation("org.springframework:spring-webflux")
    }
}
