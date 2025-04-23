// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.accounts

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
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepareAsync
import com.dinari.api.models.api.v2.accounts.wallet.Wallet
import com.dinari.api.models.api.v2.accounts.wallet.WalletRetrieveParams
import com.dinari.api.services.async.api.v2.accounts.wallet.ExternalServiceAsync
import com.dinari.api.services.async.api.v2.accounts.wallet.ExternalServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class WalletServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    WalletServiceAsync {

    private val withRawResponse: WalletServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val external: ExternalServiceAsync by lazy { ExternalServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): WalletServiceAsync.WithRawResponse = withRawResponse

    override fun external(): ExternalServiceAsync = external

    override fun retrieve(
        params: WalletRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Wallet> =
        // get /api/v2/accounts/{account_id}/wallet
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WalletServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val external: ExternalServiceAsync.WithRawResponse by lazy {
            ExternalServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun external(): ExternalServiceAsync.WithRawResponse = external

        private val retrieveHandler: Handler<Wallet> =
            jsonHandler<Wallet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: WalletRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Wallet>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "wallet")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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
    }
}
