// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountDeactivateParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        AccountDeactivateParams.builder().accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            AccountDeactivateParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
