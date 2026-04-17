// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalListParams
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalListResponse
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalRetrieveParams
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalRetrieveResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

/**
 * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a managed
 * `Wallet` to another `Account` that is owned by the `Entity`.**
 *
 * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed by Dinari
 * and the corresponding transaction is submitted on chain.
 *
 * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted on chain
 * by Dinari. Once the transfer is submitted on chain, the corresponding `Withdrawal` is created.
 *
 * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID `eip155:42161`).
 */
interface WithdrawalService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WithdrawalService

    /** Get a specific `Withdrawal` by its ID. */
    fun retrieve(
        withdrawalId: String,
        params: WithdrawalRetrieveParams,
    ): WithdrawalRetrieveResponse = retrieve(withdrawalId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        withdrawalId: String,
        params: WithdrawalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WithdrawalRetrieveResponse =
        retrieve(params.toBuilder().withdrawalId(withdrawalId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: WithdrawalRetrieveParams): WithdrawalRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WithdrawalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WithdrawalRetrieveResponse

    /** Get a list of all `Withdrawals` under the `Account`, sorted by most recent. */
    fun list(accountId: String): WithdrawalListResponse =
        list(accountId, WithdrawalListParams.none())

    /** @see list */
    fun list(
        accountId: String,
        params: WithdrawalListParams = WithdrawalListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WithdrawalListResponse =
        list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see list */
    fun list(
        accountId: String,
        params: WithdrawalListParams = WithdrawalListParams.none(),
    ): WithdrawalListResponse = list(accountId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: WithdrawalListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WithdrawalListResponse

    /** @see list */
    fun list(params: WithdrawalListParams): WithdrawalListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(accountId: String, requestOptions: RequestOptions): WithdrawalListResponse =
        list(accountId, WithdrawalListParams.none(), requestOptions)

    /** A view of [WithdrawalService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WithdrawalService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/withdrawals/{withdrawal_id}`, but is otherwise the same as
         * [WithdrawalService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            withdrawalId: String,
            params: WithdrawalRetrieveParams,
        ): HttpResponseFor<WithdrawalRetrieveResponse> =
            retrieve(withdrawalId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            withdrawalId: String,
            params: WithdrawalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WithdrawalRetrieveResponse> =
            retrieve(params.toBuilder().withdrawalId(withdrawalId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: WithdrawalRetrieveParams
        ): HttpResponseFor<WithdrawalRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: WithdrawalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WithdrawalRetrieveResponse>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/withdrawals`, but is
         * otherwise the same as [WithdrawalService.list].
         */
        @MustBeClosed
        fun list(accountId: String): HttpResponseFor<WithdrawalListResponse> =
            list(accountId, WithdrawalListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: WithdrawalListParams = WithdrawalListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WithdrawalListResponse> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            params: WithdrawalListParams = WithdrawalListParams.none(),
        ): HttpResponseFor<WithdrawalListResponse> = list(accountId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: WithdrawalListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WithdrawalListResponse>

        /** @see list */
        @MustBeClosed
        fun list(params: WithdrawalListParams): HttpResponseFor<WithdrawalListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WithdrawalListResponse> =
            list(accountId, WithdrawalListParams.none(), requestOptions)
    }
}
