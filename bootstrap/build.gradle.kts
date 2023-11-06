import org.springframework.boot.gradle.tasks.bundling.BootJar

extra["springCloudVersion"] = "2022.0.4"

dependencies {
    implementation(project(":in-adapter-messaging"))
    implementation(project(":notification-application"))
    implementation(project(":notification-domain"))
    implementation(project(":notification-in-adapter-api"))
    implementation(project(":notification-out-adapter-persistence"))
    implementation(project(":push"))
    implementation(project(":out-internal-api"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks {
    withType<Jar> { enabled = false }
    withType<BootJar> {
        enabled = true
        mainClass.set("gloddy.NotificationApplicationKt")
    }
}