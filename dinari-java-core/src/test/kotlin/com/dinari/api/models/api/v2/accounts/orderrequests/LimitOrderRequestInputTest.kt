// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orderrequests

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class LimitOrderRequestInputTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val limitOrderRequestInput =
            LimitOrderRequestInput.builder()
                .assetQuantity(0L)
                .limitPrice(0.0)
                .stockId("stock_id")
                .build()

        assertThat(limitOrderRequestInput.assetQuantity()).isEqualTo(0L)
        assertThat(limitOrderRequestInput.limitPrice()).isEqualTo(0.0)
        assertThat(limitOrderRequestInput.stockId()).isEqualTo("stock_id")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val limitOrderRequestInput =
            LimitOrderRequestInput.builder()
                .assetQuantity(0L)
                .limitPrice(0.0)
                .stockId("stock_id")
                .build()

        val roundtrippedLimitOrderRequestInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(limitOrderRequestInput),
                jacksonTypeRef<LimitOrderRequestInput>(),
            )

        assertThat(roundtrippedLimitOrderRequestInput).isEqualTo(limitOrderRequestInput)
    }
}
