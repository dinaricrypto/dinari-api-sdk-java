// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts.wallet

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.JsonValue
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.handlers.errorHandler
import com.dinari.api.core.handlers.jsonHandler
import com.dinari.api.core.handlers.withErrorHandler
import com.dinari.api.core.http.HttpMethod
import com.dinari.api.core.http.HttpRequest
import com.dinari.api.core.http.HttpResponse.Handler
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.core.http.json
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.api.v2.accounts.wallet.Wallet
import com.dinari.api.models.api.v2.accounts.wallet.external.ExternalConnectParams
import com.dinari.api.models.api.v2.accounts.wallet.external.ExternalGetNonceParams
import com.dinari.api.models.api.v2.accounts.wallet.external.ExternalGetNonceResponse
import java.util.concurrent.CompletableFuture

class ExternalServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ExternalServiceAsync {

    private val withRawResponse: ExternalServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ExternalServiceAsync.WithRawResponse = withRawResponse

    override fun connect(
        params: ExternalConnectParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Wallet> =
        // post /api/v2/accounts/{account_id}/wallet/external
        withRawResponse().connect(params, requestOptions).thenApply { it.parse() }

    override fun getNonce(
        params: ExternalGetNonceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalGetNonceResponse> =
        // get /api/v2/accounts/{account_id}/wallet/external/nonce
        withRawResponse().getNonce(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ExternalServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val connectHandler: Handler<Wallet> =
            jsonHandler<Wallet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun connect(
            params: ExternalConnectParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Wallet>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "wallet",
                        "external",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { connectHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getNonceHandler: Handler<ExternalGetNonceResponse> =
            jsonHandler<ExternalGetNonceResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getNonce(
            params: ExternalGetNonceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalGetNonceResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "wallet",
                        "external",
                        "nonce",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getNonceHandler.handle(it) }
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
