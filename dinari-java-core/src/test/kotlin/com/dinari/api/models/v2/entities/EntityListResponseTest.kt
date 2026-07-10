// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import com.dinari.api.core.jsonMapper
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityListResponseTest {

    @Test
    fun create() {
        val entityListResponse =
            EntityListResponse.builder()
                .addData(
                    EntityListResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .entityType(EntityListResponse.Data.EntityType.INDIVIDUAL)
                        .isKycComplete(true)
                        .name("name")
                        .nationality("nationality")
                        .referenceId("x")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(EntityListResponse._Sv.PAGINATED_ENTITY_RESPONSE_V1)
                .build()

        assertThat(entityListResponse.data())
            .containsExactly(
                EntityListResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .entityType(EntityListResponse.Data.EntityType.INDIVIDUAL)
                    .isKycComplete(true)
                    .name("name")
                    .nationality("nationality")
                    .referenceId("x")
                    .build()
            )
        assertThat(entityListResponse.paginationMetadata())
            .isEqualTo(PaginationMetadata.builder().next("next").previous("previous").build())
        assertThat(entityListResponse._sv())
            .contains(EntityListResponse._Sv.PAGINATED_ENTITY_RESPONSE_V1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val entityListResponse =
            EntityListResponse.builder()
                .addData(
                    EntityListResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .entityType(EntityListResponse.Data.EntityType.INDIVIDUAL)
                        .isKycComplete(true)
                        .name("name")
                        .nationality("nationality")
                        .referenceId("x")
                        .build()
                )
                .paginationMetadata(
                    PaginationMetadata.builder().next("next").previous("previous").build()
                )
                ._sv(EntityListResponse._Sv.PAGINATED_ENTITY_RESPONSE_V1)
                .build()

        val roundtrippedEntityListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(entityListResponse),
                jacksonTypeRef<EntityListResponse>(),
            )

        assertThat(roundtrippedEntityListResponse).isEqualTo(entityListResponse)
    }
}
