dependencies {
    implementation(project(":in-adapter-messaging"))
    implementation(project(":notification-application"))
    implementation(project(":notification-domain"))
    implementation(project(":notification-in-adapter-api"))
    implementation(project(":notification-out-adapter-persistence"))
    implementation(project(":push"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}