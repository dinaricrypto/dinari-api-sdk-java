// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.accounts.orderrequests.CreateLimitBuyOrderInput
import com.dinari.api.models.v2.accounts.orderrequests.CreateLimitSellOrderInput
import com.dinari.api.models.v2.accounts.orderrequests.CreateMarketBuyOrderInput
import com.dinari.api.models.v2.accounts.orderrequests.CreateMarketSellOrderInput
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderRequestServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.retrieve(
                OrderRequestRetrieveParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequests =
            orderRequestService.list(
                OrderRequestListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .clientOrderId("client_order_id")
                    .limit(20L)
                    .next("next")
                    .order(OrderRequestListParams.Order.ASC)
                    .orderId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .previous("previous")
                    .build()
            )

        orderRequests.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun createLimitBuy() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.createLimitBuy(
                OrderRequestCreateLimitBuyParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createLimitBuyOrderInput(
                        CreateLimitBuyOrderInput.builder()
                            .assetQuantity(0.0)
                            .limitPrice(0.0)
                            .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .clientOrderId("client_order_id")
                            .fee(0.0)
                            .paymentTokenAddress("payment_token_address")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun createLimitSell() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.createLimitSell(
                OrderRequestCreateLimitSellParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createLimitSellOrderInput(
                        CreateLimitSellOrderInput.builder()
                            .assetQuantity(0.0)
                            .limitPrice(0.0)
                            .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .clientOrderId("client_order_id")
                            .fee(0.0)
                            .paymentTokenAddress("payment_token_address")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun createMarketBuy() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.createMarketBuy(
                OrderRequestCreateMarketBuyParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createMarketBuyOrderInput(
                        CreateMarketBuyOrderInput.builder()
                            .paymentAmount(0.0)
                            .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .clientOrderId("client_order_id")
                            .fee(0.0)
                            .paymentTokenAddress("payment_token_address")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun createMarketSell() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequest =
            orderRequestService.createMarketSell(
                OrderRequestCreateMarketSellParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createMarketSellOrderInput(
                        CreateMarketSellOrderInput.builder()
                            .assetQuantity(0.0)
                            .alloyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .clientOrderId("client_order_id")
                            .fee(0.0)
                            .paymentTokenAddress("payment_token_address")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }
}
