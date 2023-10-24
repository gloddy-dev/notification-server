import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
	implementation(project(":notification-domain"))

	implementation("org.springframework:spring-tx")
	implementation("org.springframework:spring-context")
	implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
	implementation("jakarta.validation:jakarta.validation-api")

	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")

	testImplementation("org.assertj:assertj-core:3.24.2")
	testImplementation("org.mockito:mockito-junit-jupiter:5.3.1")
	testImplementation("org.mockito:mockito-core:5.3.1")
}

