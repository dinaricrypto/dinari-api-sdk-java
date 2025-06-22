// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts.wallet

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WalletTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val wallet =
            Wallet.builder().address("address").isAmlFlagged(true).isManagedWallet(true).build()

        assertThat(wallet.address()).isEqualTo("address")
        assertThat(wallet.isAmlFlagged()).isEqualTo(true)
        assertThat(wallet.isManagedWallet()).isEqualTo(true)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val wallet =
            Wallet.builder().address("address").isAmlFlagged(true).isManagedWallet(true).build()

        val roundtrippedWallet =
            jsonMapper.readValue(jsonMapper.writeValueAsString(wallet), jacksonTypeRef<Wallet>())

        assertThat(roundtrippedWallet).isEqualTo(wallet)
    }
}
