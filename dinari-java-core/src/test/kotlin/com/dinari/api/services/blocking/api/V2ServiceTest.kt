// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class V2ServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getHealth() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val v2Service = client.api().v2()

        val response = v2Service.getHealth()

        response.validate()
    }
}
