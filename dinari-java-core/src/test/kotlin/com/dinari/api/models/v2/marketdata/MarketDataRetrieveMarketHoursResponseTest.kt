// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MarketDataRetrieveMarketHoursResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val marketDataRetrieveMarketHoursResponse =
            MarketDataRetrieveMarketHoursResponse.builder()
                .isMarketOpen(true)
                .nextSessionCloseDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionOpenDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionAfterHoursCloseTimeDt(
                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                )
                .currentSessionCloseDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionOpenDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionOvernightOpenTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionPreMarketOpenTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionAfterHoursCloseTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionOvernightOpenTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionPreMarketOpenTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(marketDataRetrieveMarketHoursResponse.isMarketOpen()).isEqualTo(true)
        assertThat(marketDataRetrieveMarketHoursResponse.nextSessionCloseDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.nextSessionOpenDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.currentSessionAfterHoursCloseTimeDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.currentSessionCloseDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.currentSessionOpenDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.currentSessionOvernightOpenTimeDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.currentSessionPreMarketOpenTimeDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.nextSessionAfterHoursCloseTimeDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.nextSessionOvernightOpenTimeDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataRetrieveMarketHoursResponse.nextSessionPreMarketOpenTimeDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val marketDataRetrieveMarketHoursResponse =
            MarketDataRetrieveMarketHoursResponse.builder()
                .isMarketOpen(true)
                .nextSessionCloseDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionOpenDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionAfterHoursCloseTimeDt(
                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                )
                .currentSessionCloseDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionOpenDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionOvernightOpenTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionPreMarketOpenTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionAfterHoursCloseTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionOvernightOpenTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionPreMarketOpenTimeDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedMarketDataRetrieveMarketHoursResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(marketDataRetrieveMarketHoursResponse),
                jacksonTypeRef<MarketDataRetrieveMarketHoursResponse>(),
            )

        assertThat(roundtrippedMarketDataRetrieveMarketHoursResponse)
            .isEqualTo(marketDataRetrieveMarketHoursResponse)
    }
}
