// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class StockRetrieveCurrentQuoteResponseTest {

    @Test
    fun ofQuoteV1() {
        val quoteV1 =
            StockRetrieveCurrentQuoteResponse.StockQuoteV1.builder()
                .askPrice(0.0)
                .askSize(0.0)
                .bidPrice(0.0)
                .bidSize(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                ._sv(StockRetrieveCurrentQuoteResponse.StockQuoteV1._Sv.STOCK_QUOTE_V1)
                .build()

        val stockRetrieveCurrentQuoteResponse = StockRetrieveCurrentQuoteResponse.ofQuoteV1(quoteV1)

        assertThat(stockRetrieveCurrentQuoteResponse.quoteV1()).contains(quoteV1)
        assertThat(stockRetrieveCurrentQuoteResponse.quoteV2()).isEmpty
    }

    @Test
    fun ofQuoteV1Roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveCurrentQuoteResponse =
            StockRetrieveCurrentQuoteResponse.ofQuoteV1(
                StockRetrieveCurrentQuoteResponse.StockQuoteV1.builder()
                    .askPrice(0.0)
                    .askSize(0.0)
                    .bidPrice(0.0)
                    .bidSize(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    ._sv(StockRetrieveCurrentQuoteResponse.StockQuoteV1._Sv.STOCK_QUOTE_V1)
                    .build()
            )

        val roundtrippedStockRetrieveCurrentQuoteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveCurrentQuoteResponse),
                jacksonTypeRef<StockRetrieveCurrentQuoteResponse>(),
            )

        assertThat(roundtrippedStockRetrieveCurrentQuoteResponse)
            .isEqualTo(stockRetrieveCurrentQuoteResponse)
    }

    @Test
    fun ofQuoteV2() {
        val quoteV2 =
            StockRetrieveCurrentQuoteResponse.StockQuoteV2.builder()
                .askPrice(0.0)
                .askSize(0.0)
                .bidPrice(0.0)
                .bidSize(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                ._sv(StockRetrieveCurrentQuoteResponse.StockQuoteV2._Sv.STOCK_QUOTE_V2)
                .askExchange("ask_exchange")
                .bidExchange("bid_exchange")
                .build()

        val stockRetrieveCurrentQuoteResponse = StockRetrieveCurrentQuoteResponse.ofQuoteV2(quoteV2)

        assertThat(stockRetrieveCurrentQuoteResponse.quoteV1()).isEmpty
        assertThat(stockRetrieveCurrentQuoteResponse.quoteV2()).contains(quoteV2)
    }

    @Test
    fun ofQuoteV2Roundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveCurrentQuoteResponse =
            StockRetrieveCurrentQuoteResponse.ofQuoteV2(
                StockRetrieveCurrentQuoteResponse.StockQuoteV2.builder()
                    .askPrice(0.0)
                    .askSize(0.0)
                    .bidPrice(0.0)
                    .bidSize(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    ._sv(StockRetrieveCurrentQuoteResponse.StockQuoteV2._Sv.STOCK_QUOTE_V2)
                    .askExchange("ask_exchange")
                    .bidExchange("bid_exchange")
                    .build()
            )

        val roundtrippedStockRetrieveCurrentQuoteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveCurrentQuoteResponse),
                jacksonTypeRef<StockRetrieveCurrentQuoteResponse>(),
            )

        assertThat(roundtrippedStockRetrieveCurrentQuoteResponse)
            .isEqualTo(stockRetrieveCurrentQuoteResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val stockRetrieveCurrentQuoteResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<StockRetrieveCurrentQuoteResponse>())

        val e =
            assertThrows<DinariInvalidDataException> {
                stockRetrieveCurrentQuoteResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
