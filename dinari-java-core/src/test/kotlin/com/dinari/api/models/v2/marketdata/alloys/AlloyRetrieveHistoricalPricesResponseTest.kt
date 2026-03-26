// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.alloys

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AlloyRetrieveHistoricalPricesResponseTest {

    @Test
    fun create() {
        val alloyRetrieveHistoricalPricesResponse =
            AlloyRetrieveHistoricalPricesResponse.builder()
                .close(0.0)
                .high(0.0)
                .low(0.0)
                .open(0.0)
                .timestamp(0L)
                ._sv(
                    AlloyRetrieveHistoricalPricesResponse._Sv
                        .ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1
                )
                .build()

        assertThat(alloyRetrieveHistoricalPricesResponse.close()).isEqualTo(0.0)
        assertThat(alloyRetrieveHistoricalPricesResponse.high()).isEqualTo(0.0)
        assertThat(alloyRetrieveHistoricalPricesResponse.low()).isEqualTo(0.0)
        assertThat(alloyRetrieveHistoricalPricesResponse.open()).isEqualTo(0.0)
        assertThat(alloyRetrieveHistoricalPricesResponse.timestamp()).isEqualTo(0L)
        assertThat(alloyRetrieveHistoricalPricesResponse._sv())
            .contains(
                AlloyRetrieveHistoricalPricesResponse._Sv.ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val alloyRetrieveHistoricalPricesResponse =
            AlloyRetrieveHistoricalPricesResponse.builder()
                .close(0.0)
                .high(0.0)
                .low(0.0)
                .open(0.0)
                .timestamp(0L)
                ._sv(
                    AlloyRetrieveHistoricalPricesResponse._Sv
                        .ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1
                )
                .build()

        val roundtrippedAlloyRetrieveHistoricalPricesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(alloyRetrieveHistoricalPricesResponse),
                jacksonTypeRef<AlloyRetrieveHistoricalPricesResponse>(),
            )

        assertThat(roundtrippedAlloyRetrieveHistoricalPricesResponse)
            .isEqualTo(alloyRetrieveHistoricalPricesResponse)
    }
}
