// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.accounts.orderrequests.LimitOrderRequestInput
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.api.models.api.v2.accounts.orderrequests.OrderRequestRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderRequestServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderRequestServiceAsync = client.api().v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.retrieve(
                OrderRequestRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderRequestServiceAsync = client.api().v2().accounts().orderRequests()

        val orderRequestsFuture =
            orderRequestServiceAsync.list(
                OrderRequestListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val orderRequests = orderRequestsFuture.get()
        orderRequests.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createLimitBuy() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderRequestServiceAsync = client.api().v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.createLimitBuy(
                OrderRequestCreateLimitBuyParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .limitOrderRequestInput(
                        LimitOrderRequestInput.builder()
                            .assetQuantity(0L)
                            .limitPrice(0.0)
                            .stockId("stock_id")
                            .build()
                    )
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createLimitSell() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderRequestServiceAsync = client.api().v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.createLimitSell(
                OrderRequestCreateLimitSellParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .limitOrderRequestInput(
                        LimitOrderRequestInput.builder()
                            .assetQuantity(0L)
                            .limitPrice(0.0)
                            .stockId("stock_id")
                            .build()
                    )
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createMarketBuy() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderRequestServiceAsync = client.api().v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.createMarketBuy(
                OrderRequestCreateMarketBuyParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentAmount(0.0)
                    .stockId("stock_id")
                    .includeFees(true)
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createMarketSell() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderRequestServiceAsync = client.api().v2().accounts().orderRequests()

        val orderRequestFuture =
            orderRequestServiceAsync.createMarketSell(
                OrderRequestCreateMarketSellParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetQuantity(0.0)
                    .stockId("stock_id")
                    .build()
            )

        val orderRequest = orderRequestFuture.get()
        orderRequest.validate()
    }
}
