// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.alloys

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AlloyListResponseTest {

    @Test
    fun create() {
        val alloyListResponse =
            AlloyListResponse.builder()
                .addData(
                    AlloyListResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .isTradable(true)
                        .name("name")
                        .symbol("symbol")
                        ._sv(AlloyListResponse.Data._Sv.ALLOY_V1)
                        .build()
                )
                .paginationMetadata(
                    AlloyListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(AlloyListResponse._Sv.PAGINATED_ALLOY_RESPONSE_V1)
                .build()

        assertThat(alloyListResponse.data())
            .containsExactly(
                AlloyListResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .isTradable(true)
                    .name("name")
                    .symbol("symbol")
                    ._sv(AlloyListResponse.Data._Sv.ALLOY_V1)
                    .build()
            )
        assertThat(alloyListResponse.paginationMetadata())
            .isEqualTo(
                AlloyListResponse.PaginationMetadata.builder()
                    .next("next")
                    .previous("previous")
                    .build()
            )
        assertThat(alloyListResponse._sv())
            .contains(AlloyListResponse._Sv.PAGINATED_ALLOY_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val alloyListResponse =
            AlloyListResponse.builder()
                .addData(
                    AlloyListResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .isTradable(true)
                        .name("name")
                        .symbol("symbol")
                        ._sv(AlloyListResponse.Data._Sv.ALLOY_V1)
                        .build()
                )
                .paginationMetadata(
                    AlloyListResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(AlloyListResponse._Sv.PAGINATED_ALLOY_RESPONSE_V1)
                .build()

        val roundtrippedAlloyListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(alloyListResponse),
                jacksonTypeRef<AlloyListResponse>(),
            )

        assertThat(roundtrippedAlloyListResponse).isEqualTo(alloyListResponse)
    }
}
