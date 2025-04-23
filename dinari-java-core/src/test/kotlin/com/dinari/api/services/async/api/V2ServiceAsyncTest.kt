// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class V2ServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getHealth() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val v2ServiceAsync = client.api().v2()

        val responseFuture = v2ServiceAsync.getHealth()

        val response = responseFuture.get()
        response.validate()
    }
}
