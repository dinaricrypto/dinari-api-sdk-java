// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderRequestCreateLimitSellParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        OrderRequestCreateLimitSellParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .assetQuantity(JsonValue.from("0"))
            .limitPrice(JsonValue.from("0"))
            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .paymentTokenAddress("payment_token_address")
            .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            OrderRequestCreateLimitSellParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetQuantity(JsonValue.from("0"))
                .limitPrice(JsonValue.from("0"))
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            OrderRequestCreateLimitSellParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetQuantity(JsonValue.from("0"))
                .limitPrice(JsonValue.from("0"))
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenAddress("payment_token_address")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()

        assertThat(body._assetQuantity()).isEqualTo(JsonValue.from("0"))
        assertThat(body._limitPrice()).isEqualTo(JsonValue.from("0"))
        assertThat(body.stockId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.paymentTokenAddress()).contains("payment_token_address")
        assertThat(body.recipientAccountId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OrderRequestCreateLimitSellParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetQuantity(JsonValue.from("0"))
                .limitPrice(JsonValue.from("0"))
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()

        assertThat(body._assetQuantity()).isEqualTo(JsonValue.from("0"))
        assertThat(body._limitPrice()).isEqualTo(JsonValue.from("0"))
        assertThat(body.stockId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
