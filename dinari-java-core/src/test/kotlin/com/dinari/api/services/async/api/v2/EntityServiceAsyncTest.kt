// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.entities.EntityCreateParams
import com.dinari.api.models.api.v2.entities.EntityRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EntityServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val entityServiceAsync = client.api().v2().entities()

        val entityFuture = entityServiceAsync.create(EntityCreateParams.builder().name("x").build())

        val entity = entityFuture.get()
        entity.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val entityServiceAsync = client.api().v2().entities()

        val entityFuture =
            entityServiceAsync.retrieve(
                EntityRetrieveParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val entity = entityFuture.get()
        entity.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val entityServiceAsync = client.api().v2().entities()

        val entitiesFuture = entityServiceAsync.list()

        val entities = entitiesFuture.get()
        entities.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveCurrent() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val entityServiceAsync = client.api().v2().entities()

        val entityFuture = entityServiceAsync.retrieveCurrent()

        val entity = entityFuture.get()
        entity.validate()
    }
}
