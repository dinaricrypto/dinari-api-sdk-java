// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.withdrawals.Withdrawal
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalListParams
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface WithdrawalServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WithdrawalServiceAsync

    /** Get a specific `Withdrawal` by its ID. */
    fun retrieve(
        withdrawalId: String,
        params: WithdrawalRetrieveParams,
    ): CompletableFuture<Withdrawal> = retrieve(withdrawalId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        withdrawalId: String,
        params: WithdrawalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Withdrawal> =
        retrieve(params.toBuilder().withdrawalId(withdrawalId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: WithdrawalRetrieveParams): CompletableFuture<Withdrawal> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WithdrawalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Withdrawal>

    /** Get a list of all `Withdrawals` under the `Account`, sorted by most recent. */
    fun list(accountId: String): CompletableFuture<List<Withdrawal>> =
        list(accountId, WithdrawalListParams.none())

    /** @see list */
    fun list(
        accountId: String,
        params: WithdrawalListParams = WithdrawalListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Withdrawal>> =
        list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see list */
    fun list(
        accountId: String,
        params: WithdrawalListParams = WithdrawalListParams.none(),
    ): CompletableFuture<List<Withdrawal>> = list(accountId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: WithdrawalListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Withdrawal>>

    /** @see list */
    fun list(params: WithdrawalListParams): CompletableFuture<List<Withdrawal>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Withdrawal>> =
        list(accountId, WithdrawalListParams.none(), requestOptions)

    /**
     * A view of [WithdrawalServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WithdrawalServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/withdrawals/{withdrawal_id}`, but is otherwise the same as
         * [WithdrawalServiceAsync.retrieve].
         */
        fun retrieve(
            withdrawalId: String,
            params: WithdrawalRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Withdrawal>> =
            retrieve(withdrawalId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            withdrawalId: String,
            params: WithdrawalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Withdrawal>> =
            retrieve(params.toBuilder().withdrawalId(withdrawalId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: WithdrawalRetrieveParams
        ): CompletableFuture<HttpResponseFor<Withdrawal>> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: WithdrawalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Withdrawal>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/withdrawals`, but is
         * otherwise the same as [WithdrawalServiceAsync.list].
         */
        fun list(accountId: String): CompletableFuture<HttpResponseFor<List<Withdrawal>>> =
            list(accountId, WithdrawalListParams.none())

        /** @see list */
        fun list(
            accountId: String,
            params: WithdrawalListParams = WithdrawalListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Withdrawal>>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see list */
        fun list(
            accountId: String,
            params: WithdrawalListParams = WithdrawalListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<Withdrawal>>> =
            list(accountId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: WithdrawalListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Withdrawal>>>

        /** @see list */
        fun list(
            params: WithdrawalListParams
        ): CompletableFuture<HttpResponseFor<List<Withdrawal>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Withdrawal>>> =
            list(accountId, WithdrawalListParams.none(), requestOptions)
    }
}
