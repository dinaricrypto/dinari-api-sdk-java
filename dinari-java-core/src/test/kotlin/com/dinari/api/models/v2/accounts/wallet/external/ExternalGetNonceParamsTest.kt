// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet.external

import com.dinari.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalGetNonceParamsTest {

    @Test
    fun create() {
        ExternalGetNonceParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .chainId(WalletChainId.EIP155_0)
            .walletAddress("wallet_address")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ExternalGetNonceParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(WalletChainId.EIP155_0)
                .walletAddress("wallet_address")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ExternalGetNonceParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(WalletChainId.EIP155_0)
                .walletAddress("wallet_address")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("chain_id", "eip155:0")
                    .put("wallet_address", "wallet_address")
                    .build()
            )
    }
}
