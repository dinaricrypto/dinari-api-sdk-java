// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.core.JsonValue
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orderrequests.CreateLimitBuyOrderInput
import com.dinari.api.models.v2.accounts.orderrequests.CreateLimitSellOrderInput
import com.dinari.api.models.v2.accounts.orderrequests.CreateMarketBuyOrderInput
import com.dinari.api.models.v2.accounts.orderrequests.CreateMarketSellOrderInput
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateLimitSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketBuyParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestCreateMarketSellParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestGetFeeQuoteParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestListParams
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestRetrieveParams
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderType
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrderRequestServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val orderRequests =
            orderRequestService.list(
                OrderRequestListParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .page(1L)
                    .pageSize(1L)
                    .build()
            )

        orderRequests.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun createLimitBuy() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun createLimitSell() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .paymentTokenAddress("payment_token_address")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun createMarketBuy() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun createMarketSell() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
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
                            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .paymentTokenAddress("payment_token_address")
                            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        orderRequest.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun getFeeQuote() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val orderRequestService = client.v2().accounts().orderRequests()

        val response =
            orderRequestService.getFeeQuote(
                OrderRequestGetFeeQuoteParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orderSide(OrderSide.BUY)
                    .orderType(OrderType.MARKET)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetTokenQuantity(JsonValue.from("0"))
                    .chainId(Chain.EIP155_1)
                    .limitPrice(JsonValue.from("0"))
                    .paymentTokenAddress("payment_token_address")
                    .paymentTokenQuantity(JsonValue.from("0"))
                    .build()
            )

        response.validate()
    }
}
