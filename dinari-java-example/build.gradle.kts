plugins {
    id("dinari.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":dinari-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    mainClass = "com.dinari.api.example.Main"
}
