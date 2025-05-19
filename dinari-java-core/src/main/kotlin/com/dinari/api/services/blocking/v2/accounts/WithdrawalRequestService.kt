// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequest
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestCreateParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestListParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface WithdrawalRequestService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Request to withdraw USD+ payment tokens from a managed `Account` and send the equivalent
     * amount of USDC to the specified recipient `Account`.
     *
     * The recipient `Account` must belong to the same `Entity` as the managed `Account`.
     */
    fun create(accountId: String, params: WithdrawalRequestCreateParams): WithdrawalRequest =
        create(accountId, params, RequestOptions.none())

    /** @see [create] */
    fun create(
        accountId: String,
        params: WithdrawalRequestCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WithdrawalRequest = create(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [create] */
    fun create(params: WithdrawalRequestCreateParams): WithdrawalRequest =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: WithdrawalRequestCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WithdrawalRequest

    /** Get a specific `WithdrawalRequest` by its ID. */
    fun retrieve(
        withdrawalRequestId: String,
        params: WithdrawalRequestRetrieveParams,
    ): WithdrawalRequest = retrieve(withdrawalRequestId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        withdrawalRequestId: String,
        params: WithdrawalRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WithdrawalRequest =
        retrieve(
            params.toBuilder().withdrawalRequestId(withdrawalRequestId).build(),
            requestOptions,
        )

    /** @see [retrieve] */
    fun retrieve(params: WithdrawalRequestRetrieveParams): WithdrawalRequest =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: WithdrawalRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WithdrawalRequest

    /** List `WithdrawalRequests` under the `Account`, sorted by most recent. */
    fun list(accountId: String): List<WithdrawalRequest> =
        list(accountId, WithdrawalRequestListParams.none())

    /** @see [list] */
    fun list(
        accountId: String,
        params: WithdrawalRequestListParams = WithdrawalRequestListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<WithdrawalRequest> =
        list(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see [list] */
    fun list(
        accountId: String,
        params: WithdrawalRequestListParams = WithdrawalRequestListParams.none(),
    ): List<WithdrawalRequest> = list(accountId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: WithdrawalRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<WithdrawalRequest>

    /** @see [list] */
    fun list(params: WithdrawalRequestListParams): List<WithdrawalRequest> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(accountId: String, requestOptions: RequestOptions): List<WithdrawalRequest> =
        list(accountId, WithdrawalRequestListParams.none(), requestOptions)

    /**
     * A view of [WithdrawalRequestService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/withdrawal_requests`,
         * but is otherwise the same as [WithdrawalRequestService.create].
         */
        @MustBeClosed
        fun create(
            accountId: String,
            params: WithdrawalRequestCreateParams,
        ): HttpResponseFor<WithdrawalRequest> = create(accountId, params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            accountId: String,
            params: WithdrawalRequestCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WithdrawalRequest> =
            create(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [create] */
        @MustBeClosed
        fun create(params: WithdrawalRequestCreateParams): HttpResponseFor<WithdrawalRequest> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: WithdrawalRequestCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WithdrawalRequest>

        /**
         * Returns a raw HTTP response for `get
         * /api/v2/accounts/{account_id}/withdrawal_requests/{withdrawal_request_id}`, but is
         * otherwise the same as [WithdrawalRequestService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            withdrawalRequestId: String,
            params: WithdrawalRequestRetrieveParams,
        ): HttpResponseFor<WithdrawalRequest> =
            retrieve(withdrawalRequestId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            withdrawalRequestId: String,
            params: WithdrawalRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WithdrawalRequest> =
            retrieve(
                params.toBuilder().withdrawalRequestId(withdrawalRequestId).build(),
                requestOptions,
            )

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: WithdrawalRequestRetrieveParams): HttpResponseFor<WithdrawalRequest> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: WithdrawalRequestRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WithdrawalRequest>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/withdrawal_requests`,
         * but is otherwise the same as [WithdrawalRequestService.list].
         */
        @MustBeClosed
        fun list(accountId: String): HttpResponseFor<List<WithdrawalRequest>> =
            list(accountId, WithdrawalRequestListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: WithdrawalRequestListParams = WithdrawalRequestListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<WithdrawalRequest>> =
            list(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            params: WithdrawalRequestListParams = WithdrawalRequestListParams.none(),
        ): HttpResponseFor<List<WithdrawalRequest>> = list(accountId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: WithdrawalRequestListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<WithdrawalRequest>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: WithdrawalRequestListParams): HttpResponseFor<List<WithdrawalRequest>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<WithdrawalRequest>> =
            list(accountId, WithdrawalRequestListParams.none(), requestOptions)
    }
}
