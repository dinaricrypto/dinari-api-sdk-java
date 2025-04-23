// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MarketDataGetMarketHoursResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val marketDataGetMarketHoursResponse =
            MarketDataGetMarketHoursResponse.builder()
                .isMarketOpen(true)
                .nextSessionCloseDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionOpenDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionCloseDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionOpenDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(marketDataGetMarketHoursResponse.isMarketOpen()).isEqualTo(true)
        assertThat(marketDataGetMarketHoursResponse.nextSessionCloseDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataGetMarketHoursResponse.nextSessionOpenDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataGetMarketHoursResponse.currentSessionCloseDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(marketDataGetMarketHoursResponse.currentSessionOpenDt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val marketDataGetMarketHoursResponse =
            MarketDataGetMarketHoursResponse.builder()
                .isMarketOpen(true)
                .nextSessionCloseDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .nextSessionOpenDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionCloseDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currentSessionOpenDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedMarketDataGetMarketHoursResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(marketDataGetMarketHoursResponse),
                jacksonTypeRef<MarketDataGetMarketHoursResponse>(),
            )

        assertThat(roundtrippedMarketDataGetMarketHoursResponse)
            .isEqualTo(marketDataGetMarketHoursResponse)
    }
}
