// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.async.v2.accounts

import com.dinari.core.ClientOptions
import com.dinari.core.JsonValue
import com.dinari.core.RequestOptions
import com.dinari.core.checkRequired
import com.dinari.core.handlers.errorHandler
import com.dinari.core.handlers.jsonHandler
import com.dinari.core.handlers.withErrorHandler
import com.dinari.core.http.HttpMethod
import com.dinari.core.http.HttpRequest
import com.dinari.core.http.HttpResponse.Handler
import com.dinari.core.http.HttpResponseFor
import com.dinari.core.http.parseable
import com.dinari.core.prepareAsync
import com.dinari.models.v2.accounts.wallet.Wallet
import com.dinari.models.v2.accounts.wallet.WalletGetParams
import com.dinari.services.async.v2.accounts.wallet.ExternalServiceAsync
import com.dinari.services.async.v2.accounts.wallet.ExternalServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class WalletServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    WalletServiceAsync {

    private val withRawResponse: WalletServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val external: ExternalServiceAsync by lazy { ExternalServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): WalletServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WalletServiceAsync =
        WalletServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun external(): ExternalServiceAsync = external

    override fun get(
        params: WalletGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Wallet> =
        // get /api/v2/accounts/{account_id}/wallet
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WalletServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val external: ExternalServiceAsync.WithRawResponse by lazy {
            ExternalServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WalletServiceAsync.WithRawResponse =
            WalletServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun external(): ExternalServiceAsync.WithRawResponse = external

        private val getHandler: Handler<Wallet> =
            jsonHandler<Wallet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: WalletGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Wallet>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "wallet")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getHandler.handle(it) }
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
