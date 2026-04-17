// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityRetrieveByIdResponseTest {

    @Test
    fun create() {
        val entityRetrieveByIdResponse =
            EntityRetrieveByIdResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(EntityRetrieveByIdResponse.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .referenceId("x")
                .build()

        assertThat(entityRetrieveByIdResponse.id())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(entityRetrieveByIdResponse.entityType())
            .isEqualTo(EntityRetrieveByIdResponse.EntityType.INDIVIDUAL)
        assertThat(entityRetrieveByIdResponse.isKycComplete()).isEqualTo(true)
        assertThat(entityRetrieveByIdResponse.name()).contains("name")
        assertThat(entityRetrieveByIdResponse.nationality()).contains("nationality")
        assertThat(entityRetrieveByIdResponse.referenceId()).contains("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val entityRetrieveByIdResponse =
            EntityRetrieveByIdResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .entityType(EntityRetrieveByIdResponse.EntityType.INDIVIDUAL)
                .isKycComplete(true)
                .name("name")
                .nationality("nationality")
                .referenceId("x")
                .build()

        val roundtrippedEntityRetrieveByIdResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(entityRetrieveByIdResponse),
                jacksonTypeRef<EntityRetrieveByIdResponse>(),
            )

        assertThat(roundtrippedEntityRetrieveByIdResponse).isEqualTo(entityRetrieveByIdResponse)
    }
}
