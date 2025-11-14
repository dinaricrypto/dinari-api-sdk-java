// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.orderrequests

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitParams
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitResponse
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitTransactionParams
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitTransactionResponse
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155SubmitParams
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155SubmitResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface Eip155Service {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155Service

    /**
     * Generates a permit that can be signed and used to create an `OrderRequest` using Dinari's EVM
     * smart contracts.
     *
     * This is a convenience method to prepare the transactions needed to create an `OrderRequest`
     * using Dinari's EVM smart contracts. Once signed, the transactions can be sent to the EVM
     * network to create the order. Note that the fee quote is already included in the transactions,
     * so no additional fee quote lookup is needed.
     */
    fun createPermit(
        accountId: String,
        params: Eip155CreatePermitParams,
    ): Eip155CreatePermitResponse = createPermit(accountId, params, RequestOptions.none())

    /** @see createPermit */
    fun createPermit(
        accountId: String,
        params: Eip155CreatePermitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Eip155CreatePermitResponse =
        createPermit(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see createPermit */
    fun createPermit(params: Eip155CreatePermitParams): Eip155CreatePermitResponse =
        createPermit(params, RequestOptions.none())

    /** @see createPermit */
    fun createPermit(
        params: Eip155CreatePermitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Eip155CreatePermitResponse

    /**
     * Prepare a transaction to be placed on EVM. The returned structure contains the necessary data
     * to create an `EIP155Transaction` object.
     */
    fun createPermitTransaction(
        accountId: String,
        params: Eip155CreatePermitTransactionParams,
    ): Eip155CreatePermitTransactionResponse =
        createPermitTransaction(accountId, params, RequestOptions.none())

    /** @see createPermitTransaction */
    fun createPermitTransaction(
        accountId: String,
        params: Eip155CreatePermitTransactionParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Eip155CreatePermitTransactionResponse =
        createPermitTransaction(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see createPermitTransaction */
    fun createPermitTransaction(
        params: Eip155CreatePermitTransactionParams
    ): Eip155CreatePermitTransactionResponse =
        createPermitTransaction(params, RequestOptions.none())

    /** @see createPermitTransaction */
    fun createPermitTransaction(
        params: Eip155CreatePermitTransactionParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Eip155CreatePermitTransactionResponse

    /**
     * Submits a transaction for an EIP155 Order Request given the EIP155OrderRequest ID and Permit
     * Signature.
     *
     * An `EIP155OrderRequest` representing the proxied order is returned.
     */
    fun submit(accountId: String, params: Eip155SubmitParams): Eip155SubmitResponse =
        submit(accountId, params, RequestOptions.none())

    /** @see submit */
    fun submit(
        accountId: String,
        params: Eip155SubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Eip155SubmitResponse =
        submit(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see submit */
    fun submit(params: Eip155SubmitParams): Eip155SubmitResponse =
        submit(params, RequestOptions.none())

    /** @see submit */
    fun submit(
        params: Eip155SubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Eip155SubmitResponse

    /** A view of [Eip155Service] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155Service.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/eip155/permit`, but is otherwise the same as
         * [Eip155Service.createPermit].
         */
        @MustBeClosed
        fun createPermit(
            accountId: String,
            params: Eip155CreatePermitParams,
        ): HttpResponseFor<Eip155CreatePermitResponse> =
            createPermit(accountId, params, RequestOptions.none())

        /** @see createPermit */
        @MustBeClosed
        fun createPermit(
            accountId: String,
            params: Eip155CreatePermitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Eip155CreatePermitResponse> =
            createPermit(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see createPermit */
        @MustBeClosed
        fun createPermit(
            params: Eip155CreatePermitParams
        ): HttpResponseFor<Eip155CreatePermitResponse> = createPermit(params, RequestOptions.none())

        /** @see createPermit */
        @MustBeClosed
        fun createPermit(
            params: Eip155CreatePermitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Eip155CreatePermitResponse>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/eip155/permit_transaction`, but is otherwise
         * the same as [Eip155Service.createPermitTransaction].
         */
        @MustBeClosed
        fun createPermitTransaction(
            accountId: String,
            params: Eip155CreatePermitTransactionParams,
        ): HttpResponseFor<Eip155CreatePermitTransactionResponse> =
            createPermitTransaction(accountId, params, RequestOptions.none())

        /** @see createPermitTransaction */
        @MustBeClosed
        fun createPermitTransaction(
            accountId: String,
            params: Eip155CreatePermitTransactionParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Eip155CreatePermitTransactionResponse> =
            createPermitTransaction(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see createPermitTransaction */
        @MustBeClosed
        fun createPermitTransaction(
            params: Eip155CreatePermitTransactionParams
        ): HttpResponseFor<Eip155CreatePermitTransactionResponse> =
            createPermitTransaction(params, RequestOptions.none())

        /** @see createPermitTransaction */
        @MustBeClosed
        fun createPermitTransaction(
            params: Eip155CreatePermitTransactionParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Eip155CreatePermitTransactionResponse>

        /**
         * Returns a raw HTTP response for `post
         * /api/v2/accounts/{account_id}/order_requests/eip155`, but is otherwise the same as
         * [Eip155Service.submit].
         */
        @MustBeClosed
        fun submit(
            accountId: String,
            params: Eip155SubmitParams,
        ): HttpResponseFor<Eip155SubmitResponse> = submit(accountId, params, RequestOptions.none())

        /** @see submit */
        @MustBeClosed
        fun submit(
            accountId: String,
            params: Eip155SubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Eip155SubmitResponse> =
            submit(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see submit */
        @MustBeClosed
        fun submit(params: Eip155SubmitParams): HttpResponseFor<Eip155SubmitResponse> =
            submit(params, RequestOptions.none())

        /** @see submit */
        @MustBeClosed
        fun submit(
            params: Eip155SubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Eip155SubmitResponse>
    }
}
