import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":notification-application"))
    implementation(project(":notification-domain"))
    //aws sqs
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation(platform("io.awspring.cloud:spring-cloud-aws-dependencies:3.0.0"))
    implementation("io.awspring.cloud:spring-cloud-aws-starter-sqs")
}
