// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orders

import com.dinari.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderGetEstimatedFeeParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        OrderGetEstimatedFeeParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .chainId(0L)
            .contractAddress("contract_address")
            .orderData(
                OrderGetEstimatedFeeParams.OrderData.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            OrderGetEstimatedFeeParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(0L)
                .contractAddress("contract_address")
                .orderData(
                    OrderGetEstimatedFeeParams.OrderData.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            OrderGetEstimatedFeeParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(0L)
                .contractAddress("contract_address")
                .orderData(
                    OrderGetEstimatedFeeParams.OrderData.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.chainId()).isEqualTo(0L)
        assertThat(body.contractAddress()).isEqualTo("contract_address")
        assertThat(body.orderData())
            .isEqualTo(
                OrderGetEstimatedFeeParams.OrderData.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }
}
