// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.models.v2.accounts.activities.ActivityRetrieveBrokerageParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface ActivityService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ActivityService

    /**
     * Get a list of brokerage activities tied to the specified `Account`.
     *
     * **⚠️ ALPHA: This endpoint is in early development and subject to breaking changes.**
     */
    fun retrieveBrokerage(accountId: String) =
        retrieveBrokerage(accountId, ActivityRetrieveBrokerageParams.none())

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(
        accountId: String,
        params: ActivityRetrieveBrokerageParams = ActivityRetrieveBrokerageParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = retrieveBrokerage(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(
        accountId: String,
        params: ActivityRetrieveBrokerageParams = ActivityRetrieveBrokerageParams.none(),
    ) = retrieveBrokerage(accountId, params, RequestOptions.none())

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(
        params: ActivityRetrieveBrokerageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(params: ActivityRetrieveBrokerageParams) =
        retrieveBrokerage(params, RequestOptions.none())

    /** @see retrieveBrokerage */
    fun retrieveBrokerage(accountId: String, requestOptions: RequestOptions) =
        retrieveBrokerage(accountId, ActivityRetrieveBrokerageParams.none(), requestOptions)

    /** A view of [ActivityService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ActivityService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/activities/brokerage`,
         * but is otherwise the same as [ActivityService.retrieveBrokerage].
         */
        @MustBeClosed
        fun retrieveBrokerage(accountId: String): HttpResponse =
            retrieveBrokerage(accountId, ActivityRetrieveBrokerageParams.none())

        /** @see retrieveBrokerage */
        @MustBeClosed
        fun retrieveBrokerage(
            accountId: String,
            params: ActivityRetrieveBrokerageParams = ActivityRetrieveBrokerageParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            retrieveBrokerage(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see retrieveBrokerage */
        @MustBeClosed
        fun retrieveBrokerage(
            accountId: String,
            params: ActivityRetrieveBrokerageParams = ActivityRetrieveBrokerageParams.none(),
        ): HttpResponse = retrieveBrokerage(accountId, params, RequestOptions.none())

        /** @see retrieveBrokerage */
        @MustBeClosed
        fun retrieveBrokerage(
            params: ActivityRetrieveBrokerageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see retrieveBrokerage */
        @MustBeClosed
        fun retrieveBrokerage(params: ActivityRetrieveBrokerageParams): HttpResponse =
            retrieveBrokerage(params, RequestOptions.none())

        /** @see retrieveBrokerage */
        @MustBeClosed
        fun retrieveBrokerage(accountId: String, requestOptions: RequestOptions): HttpResponse =
            retrieveBrokerage(accountId, ActivityRetrieveBrokerageParams.none(), requestOptions)
    }
}
