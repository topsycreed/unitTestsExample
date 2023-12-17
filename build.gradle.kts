plugins {
    id("java")
    id("io.qameta.allure") version "2.11.0"
}

group = "org.productstar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    implementation ("io.qameta.allure:allure-junit5:2.19.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit-pioneer:junit-pioneer:2.2.0")
}

tasks.test {
    useJUnitPlatform()
}