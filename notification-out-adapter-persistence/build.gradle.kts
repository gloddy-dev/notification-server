import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":notification-application"))
    implementation(project(":notification-domain"))

//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework:spring-context")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //db 아직 뭐쓸지 모르겠어용
}


