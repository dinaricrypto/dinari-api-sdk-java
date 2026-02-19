// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.accounts.activities.ActivityRetrieveBrokerageParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ActivityServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveBrokerage() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val activityService = client.v2().accounts().activities()

        activityService.retrieveBrokerage(
            ActivityRetrieveBrokerageParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .pageSize(1L)
                .pageToken("page_token")
                .build()
        )
    }
}
