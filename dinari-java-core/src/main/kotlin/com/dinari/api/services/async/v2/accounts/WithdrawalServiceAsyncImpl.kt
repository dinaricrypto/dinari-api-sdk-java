// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.accounts

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
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalListParams
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalListResponse
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalRetrieveParams
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalRetrieveResponse
import java.util.concurrent.CompletableFuture
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
class WithdrawalServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    WithdrawalServiceAsync {

    private val withRawResponse: WithdrawalServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WithdrawalServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WithdrawalServiceAsync =
        WithdrawalServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: WithdrawalRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WithdrawalRetrieveResponse> =
        // get /api/v2/accounts/{account_id}/withdrawals/{withdrawal_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: WithdrawalListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WithdrawalListResponse> =
        // get /api/v2/accounts/{account_id}/withdrawals
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WithdrawalServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WithdrawalServiceAsync.WithRawResponse =
            WithdrawalServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<WithdrawalRetrieveResponse> =
            jsonHandler<WithdrawalRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: WithdrawalRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WithdrawalRetrieveResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("withdrawalId", params.withdrawalId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "withdrawals",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<WithdrawalListResponse> =
            jsonHandler<WithdrawalListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: WithdrawalListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WithdrawalListResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "withdrawals")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
