// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts.orderrequests

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderRequestGetFeeQuoteResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val orderRequestGetFeeQuoteResponse =
            OrderRequestGetFeeQuoteResponse.builder().fee(0.0).build()

        assertThat(orderRequestGetFeeQuoteResponse.fee()).isEqualTo(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderRequestGetFeeQuoteResponse =
            OrderRequestGetFeeQuoteResponse.builder().fee(0.0).build()

        val roundtrippedOrderRequestGetFeeQuoteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderRequestGetFeeQuoteResponse),
                jacksonTypeRef<OrderRequestGetFeeQuoteResponse>(),
            )

        assertThat(roundtrippedOrderRequestGetFeeQuoteResponse)
            .isEqualTo(orderRequestGetFeeQuoteResponse)
    }
}
