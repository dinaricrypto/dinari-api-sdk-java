// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.accounts

import com.dinari.core.ClientOptions
import com.dinari.core.RequestOptions
import com.dinari.core.http.HttpResponseFor
import com.dinari.models.v2.accounts.withdrawalrequests.WithdrawalRequest
import com.dinari.models.v2.accounts.withdrawalrequests.WithdrawalRequestCreateParams
import com.dinari.models.v2.accounts.withdrawalrequests.WithdrawalRequestListParams
import com.dinari.models.v2.accounts.withdrawalrequests.WithdrawalRequestRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface WithdrawalRequestServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WithdrawalRequestServiceAsync

    /**
     * Request to withdraw USD+ payment tokens from a managed `Account` and send the equivalent
     * amount of USDC to the specified recipient `Account`.
     *
     * The recipient `Account` must belong to the same `Entity` as the managed `Account`.
     */
    fun create(
        accountId: String,
        params: WithdrawalRequestCreateParams,
    ): CompletableFuture<WithdrawalRequest> = create(accountId, params, RequestOptions.none())

    /** @see [create] */
    fun create(
        accountId: String,
        params: WithdrawalRequestCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WithdrawalRequest> =
        create(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [create] */
    fun create(params: WithdrawalRequestCreateParams): CompletableFuture<WithdrawalRequest> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: WithdrawalRequestCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WithdrawalRequest>

    /** Get a specific `WithdrawalRequest` by its ID. */
    fun retrieve(
        withdrawalRequestId: String,
        params: WithdrawalRequestRetrieveParams,
    ): CompletableFuture<WithdrawalRequest> =
        retrieve(withdrawalRequestId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        withdrawalRequestId: String,
        params: WithdrawalRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WithdrawalRequest> =
        retrieve(
            params.toBuilder().withdrawalRequestId(withdrawalRequestId).build(),
            requestOptions,
        )

    /** @see [retrieve] */
    fun retrieve(params: WithdrawalRequestRetrieveParams): CompletableFuture<WithdrawalRequest> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: WithdrawalRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WithdrawalRequest>

    /** List `WithdrawalRequests` under the `Account`, sorted by most recent. */
    fun list(accountId: String): CompletableFuture<List<WithdrawalRequest>> =
        list(accountId, WithdrawalRequestListParams.none())

    /** @see [list] */
    fun list(
        accountId: String,
        params: WithdrawalRequestListParams = WithdrawalRequestListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<WithdrawalRequest>> =
        list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [list] */
    fun list(
        accountId: String,
        params: WithdrawalRequestListParams = WithdrawalRequestListParams.none(),
    ): CompletableFuture<List<WithdrawalRequest>> = list(accountId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: WithdrawalRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<WithdrawalRequest>>

    /** @see [list] */
    fun list(params: WithdrawalRequestListParams): CompletableFuture<List<WithdrawalRequest>> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<WithdrawalRequest>> =
        list(accountId, WithdrawalRequestListParams.none(), requestOptions)

    /**
     * A view of [WithdrawalRequestServiceAsync] that provides access to raw HTTP responses for each
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
        ): WithdrawalRequestServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/withdrawal_requests`,
         * but is otherwise the same as [WithdrawalRequestServiceAsync.create].
         */
        fun create(
            accountId: String,
            params: WithdrawalRequestCreateParams,
        ): CompletableFuture<HttpResponseFor<WithdrawalRequest>> =
            create(accountId, params, RequestOptions.none())

        /** @see [create] */
        fun create(
            accountId: String,
            params: WithdrawalRequestCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WithdrawalRequest>> =
            create(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [create] */
        fun create(
            params: WithdrawalRequestCreateParams
        ): CompletableFuture<HttpResponseFor<WithdrawalRequest>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: WithdrawalRequestCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WithdrawalRequest>>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/withdrawal_requests/{withdrawal_request_id}`, but is
         * otherwise the same as [WithdrawalRequestServiceAsync.retrieve].
         */
        fun retrieve(
            withdrawalRequestId: String,
            params: WithdrawalRequestRetrieveParams,
        ): CompletableFuture<HttpResponseFor<WithdrawalRequest>> =
            retrieve(withdrawalRequestId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            withdrawalRequestId: String,
            params: WithdrawalRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WithdrawalRequest>> =
            retrieve(
                params.toBuilder().withdrawalRequestId(withdrawalRequestId).build(),
                requestOptions,
            )

        /** @see [retrieve] */
        fun retrieve(
            params: WithdrawalRequestRetrieveParams
        ): CompletableFuture<HttpResponseFor<WithdrawalRequest>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: WithdrawalRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WithdrawalRequest>>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/withdrawal_requests`,
         * but is otherwise the same as [WithdrawalRequestServiceAsync.list].
         */
        fun list(accountId: String): CompletableFuture<HttpResponseFor<List<WithdrawalRequest>>> =
            list(accountId, WithdrawalRequestListParams.none())

        /** @see [list] */
        fun list(
            accountId: String,
            params: WithdrawalRequestListParams = WithdrawalRequestListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<WithdrawalRequest>>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [list] */
        fun list(
            accountId: String,
            params: WithdrawalRequestListParams = WithdrawalRequestListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<WithdrawalRequest>>> =
            list(accountId, params, RequestOptions.none())

        /** @see [list] */
        fun list(
            params: WithdrawalRequestListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<WithdrawalRequest>>>

        /** @see [list] */
        fun list(
            params: WithdrawalRequestListParams
        ): CompletableFuture<HttpResponseFor<List<WithdrawalRequest>>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<WithdrawalRequest>>> =
            list(accountId, WithdrawalRequestListParams.none(), requestOptions)
    }
}
