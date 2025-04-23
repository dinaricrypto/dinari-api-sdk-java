// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.accounts

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
import com.dinari.api.core.prepare
import com.dinari.api.models.api.v2.accounts.wallet.Wallet
import com.dinari.api.models.api.v2.accounts.wallet.WalletRetrieveParams
import com.dinari.api.services.blocking.api.v2.accounts.wallet.ExternalService
import com.dinari.api.services.blocking.api.v2.accounts.wallet.ExternalServiceImpl

class WalletServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WalletService {

    private val withRawResponse: WalletService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val external: ExternalService by lazy { ExternalServiceImpl(clientOptions) }

    override fun withRawResponse(): WalletService.WithRawResponse = withRawResponse

    override fun external(): ExternalService = external

    override fun retrieve(params: WalletRetrieveParams, requestOptions: RequestOptions): Wallet =
        // get /api/v2/accounts/{account_id}/wallet
        withRawResponse().retrieve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WalletService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val external: ExternalService.WithRawResponse by lazy {
            ExternalServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun external(): ExternalService.WithRawResponse = external

        private val retrieveHandler: Handler<Wallet> =
            jsonHandler<Wallet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: WalletRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Wallet> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "wallet")
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
    }
}
