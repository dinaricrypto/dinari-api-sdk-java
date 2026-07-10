// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.alloys

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginationMetadataTest {

    @Test
    fun create() {
        val paginationMetadata =
            PaginationMetadata.builder().next("next").previous("previous").build()

        assertThat(paginationMetadata.next()).contains("next")
        assertThat(paginationMetadata.previous()).contains("previous")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginationMetadata =
            PaginationMetadata.builder().next("next").previous("previous").build()

        val roundtrippedPaginationMetadata =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginationMetadata),
                jacksonTypeRef<PaginationMetadata>(),
            )

        assertThat(roundtrippedPaginationMetadata).isEqualTo(paginationMetadata)
    }
}
