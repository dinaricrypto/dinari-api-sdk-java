// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.alloys

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AlloyRetrieveCurrentPriceResponseTest {

    @Test
    fun create() {
        val alloyRetrieveCurrentPriceResponse =
            AlloyRetrieveCurrentPriceResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .price(0.0)
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                ._sv(AlloyRetrieveCurrentPriceResponse._Sv.ALLOY_PRICE_V1)
                .build()

        assertThat(alloyRetrieveCurrentPriceResponse.id())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(alloyRetrieveCurrentPriceResponse.price()).isEqualTo(0.0)
        assertThat(alloyRetrieveCurrentPriceResponse.timestamp())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(alloyRetrieveCurrentPriceResponse._sv())
            .contains(AlloyRetrieveCurrentPriceResponse._Sv.ALLOY_PRICE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val alloyRetrieveCurrentPriceResponse =
            AlloyRetrieveCurrentPriceResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .price(0.0)
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                ._sv(AlloyRetrieveCurrentPriceResponse._Sv.ALLOY_PRICE_V1)
                .build()

        val roundtrippedAlloyRetrieveCurrentPriceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(alloyRetrieveCurrentPriceResponse),
                jacksonTypeRef<AlloyRetrieveCurrentPriceResponse>(),
            )

        assertThat(roundtrippedAlloyRetrieveCurrentPriceResponse)
            .isEqualTo(alloyRetrieveCurrentPriceResponse)
    }
}
