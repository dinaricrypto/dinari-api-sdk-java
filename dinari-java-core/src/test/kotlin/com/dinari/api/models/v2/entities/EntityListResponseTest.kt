// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class EntityListResponseTest {

    @Test
    fun ofEntities() {
        val entities =
            listOf(
                Entity.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .entityType(Entity.EntityType.INDIVIDUAL)
                    .isKycComplete(true)
                    .name("name")
                    .nationality("nationality")
                    .referenceId("x")
                    .build()
            )

        val entityListResponse = EntityListResponse.ofEntities(entities)

        assertThat(entityListResponse.entities()).contains(entities)
        assertThat(entityListResponse.paginatedEntity()).isEmpty
    }

    @Test
    fun ofEntitiesRoundtrip() {
        val jsonMapper = jsonMapper()
        val entityListResponse =
            EntityListResponse.ofEntities(
                listOf(
                    Entity.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .entityType(Entity.EntityType.INDIVIDUAL)
                        .isKycComplete(true)
                        .name("name")
                        .nationality("nationality")
                        .referenceId("x")
                        .build()
                )
            )

        val roundtrippedEntityListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(entityListResponse),
                jacksonTypeRef<EntityListResponse>(),
            )

        assertThat(roundtrippedEntityListResponse).isEqualTo(entityListResponse)
    }

    @Test
    fun ofPaginatedEntity() {
        val paginatedEntity =
            EntityListResponse.PaginatedEntityResponse.builder()
                .addData(
                    Entity.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .entityType(Entity.EntityType.INDIVIDUAL)
                        .isKycComplete(true)
                        .name("name")
                        .nationality("nationality")
                        .referenceId("x")
                        .build()
                )
                .paginationMetadata(
                    EntityListResponse.PaginatedEntityResponse.PaginationMetadata.builder()
                        .next("next")
                        .previous("previous")
                        .build()
                )
                ._sv(EntityListResponse.PaginatedEntityResponse._Sv.PAGINATED_ENTITY_RESPONSE_V1)
                .build()

        val entityListResponse = EntityListResponse.ofPaginatedEntity(paginatedEntity)

        assertThat(entityListResponse.entities()).isEmpty
        assertThat(entityListResponse.paginatedEntity()).contains(paginatedEntity)
    }

    @Test
    fun ofPaginatedEntityRoundtrip() {
        val jsonMapper = jsonMapper()
        val entityListResponse =
            EntityListResponse.ofPaginatedEntity(
                EntityListResponse.PaginatedEntityResponse.builder()
                    .addData(
                        Entity.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .entityType(Entity.EntityType.INDIVIDUAL)
                            .isKycComplete(true)
                            .name("name")
                            .nationality("nationality")
                            .referenceId("x")
                            .build()
                    )
                    .paginationMetadata(
                        EntityListResponse.PaginatedEntityResponse.PaginationMetadata.builder()
                            .next("next")
                            .previous("previous")
                            .build()
                    )
                    ._sv(
                        EntityListResponse.PaginatedEntityResponse._Sv.PAGINATED_ENTITY_RESPONSE_V1
                    )
                    .build()
            )

        val roundtrippedEntityListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(entityListResponse),
                jacksonTypeRef<EntityListResponse>(),
            )

        assertThat(roundtrippedEntityListResponse).isEqualTo(entityListResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val entityListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<EntityListResponse>())

        val e = assertThrows<DinariInvalidDataException> { entityListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
