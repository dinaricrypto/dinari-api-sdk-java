// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentQueryParams
import com.dinari.api.models.api.v2.accounts.orderfulfillments.OrderFulfillmentRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderFulfillmentServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderFulfillmentService = client.api().v2().accounts().orderFulfillments()

        val orderFulfillment =
            orderFulfillmentService.retrieve(
                OrderFulfillmentRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .fulfillmentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        orderFulfillment.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun query() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderFulfillmentService = client.api().v2().accounts().orderFulfillments()

        val orderFulfillments =
            orderFulfillmentService.query(
                OrderFulfillmentQueryParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        orderFulfillments.forEach { it.validate() }
    }
}
