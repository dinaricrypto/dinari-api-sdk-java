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
import com.dinari.api.core.http.parseable
import com.dinari.api.core.prepare
import com.dinari.api.models.v2.accounts.wallet.Wallet
import com.dinari.api.models.v2.accounts.wallet.WalletGetParams
import com.dinari.api.services.blocking.v2.accounts.wallet.ExternalService
import com.dinari.api.services.blocking.v2.accounts.wallet.ExternalServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class WalletServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WalletService {

    private val withRawResponse: WalletService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val external: ExternalService by lazy { ExternalServiceImpl(clientOptions) }

    override fun withRawResponse(): WalletService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WalletService =
        WalletServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun external(): ExternalService = external

    override fun get(params: WalletGetParams, requestOptions: RequestOptions): Wallet =
        // get /api/v2/accounts/{account_id}/wallet
        withRawResponse().get(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WalletService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val external: ExternalService.WithRawResponse by lazy {
            ExternalServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WalletService.WithRawResponse =
            WalletServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun external(): ExternalService.WithRawResponse = external

        private val getHandler: Handler<Wallet> =
            jsonHandler<Wallet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: WalletGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Wallet> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "wallet")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
