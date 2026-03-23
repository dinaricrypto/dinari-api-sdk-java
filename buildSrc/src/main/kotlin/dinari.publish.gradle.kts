import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

publishing {
  repositories {
      if (project.hasProperty("publishLocal")) {
          maven {
              name = "LocalFileSystem"
              url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
          }
      }
  }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    if (!project.hasProperty("publishLocal")) {
        signAllPublications()
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

    pom {
        name.set("Dinari Enterprise API")
        description.set("**Dinari API for enterprise usage.**\n\nDinari's dShares let businesses offer tokenized access to stocks to their\ncustomers through an easy-to-use API. Integrate Dinari's API and offer over a\nhundred stocks and ETFs to your customers.")
        url.set("https://docs.dinari.com/")

        licenses {
            license {
                name.set("Apache-2.0")
            }
        }

        developers {
            developer {
                name.set("Dinari")
                email.set("hello@dinari.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/dinaricrypto/dinari-api-sdk-java.git")
            developerConnection.set("scm:git:git://github.com/dinaricrypto/dinari-api-sdk-java.git")
            url.set("https://github.com/dinaricrypto/dinari-api-sdk-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
