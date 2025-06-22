// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts.orders.stocks

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.core.JsonValue
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import com.dinari.api.models.v2.accounts.orders.stocks.eip155.Eip155GetFeeQuoteParams
import com.dinari.api.models.v2.accounts.orders.stocks.eip155.Eip155PrepareOrderParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class Eip155ServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getFeeQuote() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155ServiceAsync = client.v2().accounts().orders().stocks().eip155()

        val responseFuture =
            eip155ServiceAsync.getFeeQuote(
                Eip155GetFeeQuoteParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderType(OrderType.MARKET)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetTokenQuantity(JsonValue.from("0"))
                    .limitPrice(JsonValue.from("0"))
                    .paymentToken("payment_token")
                    .paymentTokenQuantity(JsonValue.from("0"))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun prepareOrder() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155ServiceAsync = client.v2().accounts().orders().stocks().eip155()

        val responseFuture =
            eip155ServiceAsync.prepareOrder(
                Eip155PrepareOrderParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderType(OrderType.MARKET)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .assetTokenQuantity(JsonValue.from("0"))
                    .limitPrice(JsonValue.from("0"))
                    .paymentToken("payment_token")
                    .paymentTokenQuantity(JsonValue.from("0"))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
