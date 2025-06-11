// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.JsonValue
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.checkRequired
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.handlers.withErrorHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.json
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequest
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestCreateParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestListParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestRetrieveParams
import kotlin.jvm.optionals.getOrNull

class WithdrawalRequestServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WithdrawalRequestService {

    private val withRawResponse: WithdrawalRequestService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WithdrawalRequestService.WithRawResponse = withRawResponse

    override fun create(
        params: WithdrawalRequestCreateParams,
        requestOptions: RequestOptions,
    ): WithdrawalRequest =
        // post /api/v2/accounts/{account_id}/withdrawal_requests
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: WithdrawalRequestRetrieveParams,
        requestOptions: RequestOptions,
    ): WithdrawalRequest =
        // get /api/v2/accounts/{account_id}/withdrawal_requests/{withdrawal_request_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: WithdrawalRequestListParams,
        requestOptions: RequestOptions,
    ): List<WithdrawalRequest> =
        // get /api/v2/accounts/{account_id}/withdrawal_requests
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WithdrawalRequestService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<WithdrawalRequest> =
            jsonHandler<WithdrawalRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: WithdrawalRequestCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WithdrawalRequest> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "withdrawal_requests",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<WithdrawalRequest> =
            jsonHandler<WithdrawalRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: WithdrawalRequestRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WithdrawalRequest> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("withdrawalRequestId", params.withdrawalRequestId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "withdrawal_requests",
                        params._pathParam(1),
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<List<WithdrawalRequest>> =
            jsonHandler<List<WithdrawalRequest>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: WithdrawalRequestListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<WithdrawalRequest>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "withdrawal_requests",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }
    }
}
