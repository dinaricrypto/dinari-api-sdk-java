plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Dinari Enterprise API")
                description.set("**Dinari API for enterprise usage.**\n\nDinari's dShares let businesses offer tokenized access to stocks to their\ncustomers through an easy-to-use API. Integrate Dinari's API and offer over a\nhundred stocks and ETFs to your customers.")

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
                    connection.set("scm:git:git://github.com/stainless-sdks/dinari-java.git")
                    developerConnection.set("scm:git:git://github.com/stainless-sdks/dinari-java.git")
                    url.set("https://github.com/stainless-sdks/dinari-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
