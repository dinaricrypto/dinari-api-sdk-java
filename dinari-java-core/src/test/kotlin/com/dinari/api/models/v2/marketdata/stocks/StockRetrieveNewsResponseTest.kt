// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StockRetrieveNewsResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val stockRetrieveNewsResponse =
            StockRetrieveNewsResponse.builder()
                .articleUrl("article_url")
                .description("description")
                .imageUrl("image_url")
                .publishedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .publisher("publisher")
                .ampUrl("amp_url")
                .build()

        assertThat(stockRetrieveNewsResponse.articleUrl()).isEqualTo("article_url")
        assertThat(stockRetrieveNewsResponse.description()).isEqualTo("description")
        assertThat(stockRetrieveNewsResponse.imageUrl()).isEqualTo("image_url")
        assertThat(stockRetrieveNewsResponse.publishedDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(stockRetrieveNewsResponse.publisher()).isEqualTo("publisher")
        assertThat(stockRetrieveNewsResponse.ampUrl()).contains("amp_url")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveNewsResponse =
            StockRetrieveNewsResponse.builder()
                .articleUrl("article_url")
                .description("description")
                .imageUrl("image_url")
                .publishedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .publisher("publisher")
                .ampUrl("amp_url")
                .build()

        val roundtrippedStockRetrieveNewsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveNewsResponse),
                jacksonTypeRef<StockRetrieveNewsResponse>(),
            )

        assertThat(roundtrippedStockRetrieveNewsResponse).isEqualTo(stockRetrieveNewsResponse)
    }
}
