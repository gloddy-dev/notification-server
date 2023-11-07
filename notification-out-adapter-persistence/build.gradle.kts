import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":notification-application"))
    implementation(project(":notification-domain"))

    implementation("com.amazonaws:aws-java-sdk-dynamodb:1.12.497")
    implementation("io.github.boostchicken:spring-data-dynamodb:5.2.5")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-context")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


