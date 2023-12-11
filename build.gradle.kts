plugins {
    id("java")
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
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.seleniumhq.selenium:selenium-java:4.16.1")
    testImplementation("io.github.bonigarcia:selenium-jupiter:5.0.0")
}

tasks.test {
    useJUnitPlatform()
}