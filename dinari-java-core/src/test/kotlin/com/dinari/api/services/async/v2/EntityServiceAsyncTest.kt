// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2

import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.entities.EntityCreateParams
import com.dinari.api.models.v2.entities.EntityListParams
import com.dinari.api.models.v2.entities.EntityUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EntityServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            DinariOkHttpClientAsync.builder()
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            DinariOkHttpClientAsync.builder()
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val entityServiceAsync = client.v2().entities()

        val entitiesFuture =
            entityServiceAsync.list(
                EntityListParams.builder()
                    .limit(20L)
                    .next("next")
                    .order(EntityListParams.Order.ASC)
                    .page(1L)
                    .pageSize(1L)
                    .previous("previous")
                    .referenceId("x")
                    .build()
            )

        val entities = entitiesFuture.get()
        entities.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveById() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val entityServiceAsync = client.v2().entities()

        val responseFuture = entityServiceAsync.retrieveById("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveCurrent() {
        val client =
            DinariOkHttpClientAsync.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val entityServiceAsync = client.v2().entities()

        val responseFuture = entityServiceAsync.retrieveCurrent()

        val response = responseFuture.get()
        response.validate()
    }
}
