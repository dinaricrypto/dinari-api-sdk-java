// File generated from our OpenAPI spec by Stainless.

package com.dinari.services.blocking.v2.accounts.wallet

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
import com.dinari.core.http.json
import com.dinari.core.http.parseable
import com.dinari.core.prepare
import com.dinari.models.v2.accounts.wallet.Wallet
import com.dinari.models.v2.accounts.wallet.external.ExternalConnectParams
import com.dinari.models.v2.accounts.wallet.external.ExternalGetNonceParams
import com.dinari.models.v2.accounts.wallet.external.ExternalGetNonceResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ExternalServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ExternalService {

    private val withRawResponse: ExternalService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ExternalService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExternalService =
        ExternalServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun connect(params: ExternalConnectParams, requestOptions: RequestOptions): Wallet =
        // post /api/v2/accounts/{account_id}/wallet/external
        withRawResponse().connect(params, requestOptions).parse()

    override fun getNonce(
        params: ExternalGetNonceParams,
        requestOptions: RequestOptions,
    ): ExternalGetNonceResponse =
        // get /api/v2/accounts/{account_id}/wallet/external/nonce
        withRawResponse().getNonce(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ExternalService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ExternalService.WithRawResponse =
            ExternalServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val connectHandler: Handler<Wallet> =
            jsonHandler<Wallet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun connect(
            params: ExternalConnectParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Wallet> {
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
                        "wallet",
                        "external",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { connectHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<ExternalGetNonceResponse> {
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
                        "wallet",
                        "external",
                        "nonce",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
