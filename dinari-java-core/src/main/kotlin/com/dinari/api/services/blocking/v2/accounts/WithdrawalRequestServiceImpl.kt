// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.checkRequired
import com.dinari.api.core.handlers.errorBodyHandler
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.json
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestCreateParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestCreateResponse
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestListParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestListResponse
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestRetrieveParams
import com.dinari.api.models.v2.accounts.withdrawalrequests.WithdrawalRequestRetrieveResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

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
class WithdrawalRequestServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WithdrawalRequestService {

    private val withRawResponse: WithdrawalRequestService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WithdrawalRequestService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WithdrawalRequestService =
        WithdrawalRequestServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: WithdrawalRequestCreateParams,
        requestOptions: RequestOptions,
    ): WithdrawalRequestCreateResponse =
        // post /api/v2/accounts/{account_id}/withdrawal_requests
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: WithdrawalRequestRetrieveParams,
        requestOptions: RequestOptions,
    ): WithdrawalRequestRetrieveResponse =
        // get /api/v2/accounts/{account_id}/withdrawal_requests/{withdrawal_request_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: WithdrawalRequestListParams,
        requestOptions: RequestOptions,
    ): WithdrawalRequestListResponse =
        // get /api/v2/accounts/{account_id}/withdrawal_requests
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WithdrawalRequestService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WithdrawalRequestService.WithRawResponse =
            WithdrawalRequestServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<WithdrawalRequestCreateResponse> =
            jsonHandler<WithdrawalRequestCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: WithdrawalRequestCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WithdrawalRequestCreateResponse> {
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
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<WithdrawalRequestRetrieveResponse> =
            jsonHandler<WithdrawalRequestRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: WithdrawalRequestRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WithdrawalRequestRetrieveResponse> {
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
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<WithdrawalRequestListResponse> =
            jsonHandler<WithdrawalRequestListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: WithdrawalRequestListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WithdrawalRequestListResponse> {
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
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
