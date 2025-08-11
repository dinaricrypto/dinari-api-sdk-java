// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.entities.EntityCreateParams
import com.dinari.api.models.v2.entities.EntityListParams
import com.dinari.api.models.v2.entities.EntityUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EntityServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val entityServiceAsync = client.v2().entities()

        val entityFuture =
            entityServiceAsync.create(
                EntityCreateParams.builder().name("x").referenceId("x").build()
            )

        val entity = entityFuture.get()
        entity.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val entityServiceAsync = client.v2().entities()

        val entityFuture =
            entityServiceAsync.update(
                EntityUpdateParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .referenceId("x")
                    .build()
            )

        val entity = entityFuture.get()
        entity.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val entityServiceAsync = client.v2().entities()

        val entitiesFuture =
            entityServiceAsync.list(
                EntityListParams.builder().page(1L).pageSize(1L).referenceId("x").build()
            )

        val entities = entitiesFuture.get()
        entities.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveById() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val entityServiceAsync = client.v2().entities()

        val entityFuture = entityServiceAsync.retrieveById("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val entity = entityFuture.get()
        entity.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveCurrent() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val entityServiceAsync = client.v2().entities()

        val entityFuture = entityServiceAsync.retrieveCurrent()

        val entity = entityFuture.get()
        entity.validate()
    }
}
