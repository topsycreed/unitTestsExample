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
    testImplementation("org.testng:testng:7.8.0")
}

tasks.test {
    useTestNG()
}