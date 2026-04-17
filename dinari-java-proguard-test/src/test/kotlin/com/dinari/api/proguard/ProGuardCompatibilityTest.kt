// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.proguard

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.entities.accounts.Jurisdiction
import com.dinari.api.models.v2.marketdata.stocks.StockListResponse
import com.dinari.api.models.v2.marketdata.stocks.StockRetrieveCurrentPriceResponse
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/dinari-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()

        assertThat(client).isNotNull()
        assertThat(client.v2()).isNotNull()
    }

    @Test
    fun stockRetrieveCurrentPriceResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val stockRetrieveCurrentPriceResponse =
            StockRetrieveCurrentPriceResponse.builder()
                .price(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .change(0.0)
                .changePercent(0.0)
                .close(0.0)
                .high(0.0)
                .low(0.0)
                .marketCap(0L)
                .open(0.0)
                .previousClose(0.0)
                .volume(0.0)
                .weightedSharesOutstanding(0L)
                .build()

        val roundtrippedStockRetrieveCurrentPriceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockRetrieveCurrentPriceResponse),
                jacksonTypeRef<StockRetrieveCurrentPriceResponse>(),
            )

        assertThat(roundtrippedStockRetrieveCurrentPriceResponse)
            .isEqualTo(stockRetrieveCurrentPriceResponse)
    }

    @Test
    fun stockListResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val stockListResponse =
            StockListResponse.ofStocks(
                listOf(
                    StockListResponse.Stock.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .isFractionable(true)
                        .isTradable(true)
                        .name("name")
                        .symbol("symbol")
                        .addToken("string")
                        .cik("cik")
                        .compositeFigi("composite_figi")
                        .cusip("cusip")
                        .description("description")
                        .displayName("display_name")
                        .logoUrl("logo_url")
                        .build()
                )
            )

        val roundtrippedStockListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stockListResponse),
                jacksonTypeRef<StockListResponse>(),
            )

        assertThat(roundtrippedStockListResponse).isEqualTo(stockListResponse)
    }

    @Test
    fun jurisdictionRoundtrip() {
        val jsonMapper = jsonMapper()
        val jurisdiction = Jurisdiction.BASELINE

        val roundtrippedJurisdiction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jurisdiction),
                jacksonTypeRef<Jurisdiction>(),
            )

        assertThat(roundtrippedJurisdiction).isEqualTo(jurisdiction)
    }
}
