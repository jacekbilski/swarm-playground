apply(plugin = "org.springframework.boot")

group = "tech.bilski.swarm-playground"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.micrometer:micrometer-registry-elastic")
}
