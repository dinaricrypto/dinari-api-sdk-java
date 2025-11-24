// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.accounts.activities.ActivityRetrieveBrokerageParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ActivityServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveBrokerage() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val activityServiceAsync = client.v2().accounts().activities()

        val future =
            activityServiceAsync.retrieveBrokerage(
                ActivityRetrieveBrokerageParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .pageSize(1L)
                    .pageToken("page_token")
                    .build()
            )

        val response = future.get()
    }
}
