import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
        kotlin("plugin.jpa") version "1.5.21"
    kotlin("plugin.allopen") version "1.5.21" //entities should be open
}

// for JPA purposes: In order to make lazy fetching working as expected, entities should be open
allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

// apply ("./gradle/build-integration-test.gradle")

group = "com.amm.poc"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    // implementation
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Api docs
    implementation("io.springfox:springfox-swagger2:2.7.0")
    implementation("io.springfox:springfox-swagger-ui:2.7.0")

    // Database
    implementation("org.postgresql:postgresql:42.2.5")
    implementation("org.flywaydb:flyway-core:5.2.4")

    // testing junit5
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
        exclude(module = "mockito-core")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.ninja-squad:springmockk:3.0.1")
	testImplementation("io.rest-assured:spring-mock-mvc:3.1.1")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.13")
    testImplementation("net.javacrumbs.json-unit:json-unit-fluent:2.22.0")
    testImplementation ("com.palantir.docker.compose:docker-compose-junit-jupiter:1.7.0")
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

springBoot {
    mainClass.set("com.amm.poc.blog.infrastructure.BlogApplicationKt")
}
