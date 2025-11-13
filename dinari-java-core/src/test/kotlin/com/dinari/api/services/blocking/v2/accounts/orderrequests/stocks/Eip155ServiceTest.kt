// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.orderrequests.stocks

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155.Eip155PrepareProxiedOrderParams
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class Eip155ServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun prepareProxiedOrder() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val eip155Service = client.v2().accounts().orderRequests().stocks().eip155()

        val response =
            eip155Service.prepareProxiedOrder(
                Eip155PrepareProxiedOrderParams.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .chainId(Chain.EIP155_1)
                    .orderSide(OrderSide.BUY)
                    .orderTif(OrderTif.DAY)
                    .orderType(OrderType.MARKET)
                    .paymentToken("payment_token")
                    .assetTokenQuantity(0.0)
                    .clientOrderId("client_order_id")
                    .limitPrice(0.0)
                    .paymentTokenQuantity(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .tokenId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.validate()
    }
}
