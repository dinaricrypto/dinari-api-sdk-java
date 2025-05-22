// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.withdrawals.Withdrawal
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalListParams
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface WithdrawalService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Get a specific `Withdrawal` by its ID. */
    fun retrieve(withdrawalId: String, params: WithdrawalRetrieveParams): Withdrawal =
        retrieve(withdrawalId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        withdrawalId: String,
        params: WithdrawalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Withdrawal = retrieve(params.toBuilder().withdrawalId(withdrawalId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: WithdrawalRetrieveParams): Withdrawal =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: WithdrawalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Withdrawal

    /** Get a list of all `Withdrawals` under the `Account`, sorted by most recent. */
    fun list(accountId: String): List<Withdrawal> = list(accountId, WithdrawalListParams.none())

    /** @see [list] */
    fun list(
        accountId: String,
        params: WithdrawalListParams = WithdrawalListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Withdrawal> = list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [list] */
    fun list(
        accountId: String,
        params: WithdrawalListParams = WithdrawalListParams.none(),
    ): List<Withdrawal> = list(accountId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: WithdrawalListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Withdrawal>

    /** @see [list] */
    fun list(params: WithdrawalListParams): List<Withdrawal> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(accountId: String, requestOptions: RequestOptions): List<Withdrawal> =
        list(accountId, WithdrawalListParams.none(), requestOptions)

    /** A view of [WithdrawalService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/withdrawals/{withdrawal_id}`, but is otherwise the same as
         * [WithdrawalService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            withdrawalId: String,
            params: WithdrawalRetrieveParams,
        ): HttpResponseFor<Withdrawal> = retrieve(withdrawalId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            withdrawalId: String,
            params: WithdrawalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Withdrawal> =
            retrieve(params.toBuilder().withdrawalId(withdrawalId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: WithdrawalRetrieveParams): HttpResponseFor<Withdrawal> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: WithdrawalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Withdrawal>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/withdrawals`, but is
         * otherwise the same as [WithdrawalService.list].
         */
        @MustBeClosed
        fun list(accountId: String): HttpResponseFor<List<Withdrawal>> =
            list(accountId, WithdrawalListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: WithdrawalListParams = WithdrawalListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Withdrawal>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: WithdrawalListParams = WithdrawalListParams.none(),
        ): HttpResponseFor<List<Withdrawal>> = list(accountId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: WithdrawalListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Withdrawal>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: WithdrawalListParams): HttpResponseFor<List<Withdrawal>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Withdrawal>> =
            list(accountId, WithdrawalListParams.none(), requestOptions)
    }
}
