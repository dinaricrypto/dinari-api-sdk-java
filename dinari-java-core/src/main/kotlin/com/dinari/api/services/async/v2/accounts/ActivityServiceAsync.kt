// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.models.v2.accounts.activities.ActivityRetrieveBrokerageParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ActivityServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ActivityServiceAsync

    /**
     * Get a list of brokerage activities tied to the specified `Account`.
     *
     * **⚠️ ALPHA: This endpoint is in early development and subject to breaking changes.**
     */
    fun retrieveBrokerage(accountId: String): CompletableFuture<Void?> =
        retrieveBrokerage(accountId, ActivityRetrieveBrokerageParams.none())

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(
        accountId: String,
        params: ActivityRetrieveBrokerageParams = ActivityRetrieveBrokerageParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        retrieveBrokerage(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(
        accountId: String,
        params: ActivityRetrieveBrokerageParams = ActivityRetrieveBrokerageParams.none(),
    ): CompletableFuture<Void?> = retrieveBrokerage(accountId, params, RequestOptions.none())

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(
        params: ActivityRetrieveBrokerageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(params: ActivityRetrieveBrokerageParams): CompletableFuture<Void?> =
        retrieveBrokerage(params, RequestOptions.none())

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(
        accountId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        retrieveBrokerage(accountId, ActivityRetrieveBrokerageParams.none(), requestOptions)

    /**
     * A view of [ActivityServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ActivityServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/activities/brokerage`,
         * but is otherwise the same as [ActivityServiceAsync.retrieveBrokerage].
         */
        fun retrieveBrokerage(accountId: String): CompletableFuture<HttpResponse> =
            retrieveBrokerage(accountId, ActivityRetrieveBrokerageParams.none())

        /** @see retrieveBrokerage */
        fun retrieveBrokerage(
            accountId: String,
            params: ActivityRetrieveBrokerageParams = ActivityRetrieveBrokerageParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            retrieveBrokerage(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see retrieveBrokerage */
        fun retrieveBrokerage(
            accountId: String,
            params: ActivityRetrieveBrokerageParams = ActivityRetrieveBrokerageParams.none(),
        ): CompletableFuture<HttpResponse> =
            retrieveBrokerage(accountId, params, RequestOptions.none())

        /** @see retrieveBrokerage */
        fun retrieveBrokerage(
            params: ActivityRetrieveBrokerageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see retrieveBrokerage */
        fun retrieveBrokerage(
            params: ActivityRetrieveBrokerageParams
        ): CompletableFuture<HttpResponse> = retrieveBrokerage(params, RequestOptions.none())

        /** @see retrieveBrokerage */
        fun retrieveBrokerage(
            accountId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            retrieveBrokerage(accountId, ActivityRetrieveBrokerageParams.none(), requestOptions)
    }
}
