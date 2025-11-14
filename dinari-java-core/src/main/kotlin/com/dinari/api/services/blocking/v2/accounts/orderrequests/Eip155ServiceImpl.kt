// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.accounts.orderrequests

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
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitParams
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitResponse
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitTransactionParams
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155CreatePermitTransactionResponse
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155SubmitParams
import com.dinari.api.models.v2.accounts.orderrequests.eip155.Eip155SubmitResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class Eip155ServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    Eip155Service {

    private val withRawResponse: Eip155Service.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): Eip155Service.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): Eip155Service =
        Eip155ServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun createPermit(
        params: Eip155CreatePermitParams,
        requestOptions: RequestOptions,
    ): Eip155CreatePermitResponse =
        // post /api/v2/accounts/{account_id}/order_requests/eip155/permit
        withRawResponse().createPermit(params, requestOptions).parse()

    override fun createPermitTransaction(
        params: Eip155CreatePermitTransactionParams,
        requestOptions: RequestOptions,
    ): Eip155CreatePermitTransactionResponse =
        // post /api/v2/accounts/{account_id}/order_requests/eip155/permit_transaction
        withRawResponse().createPermitTransaction(params, requestOptions).parse()

    override fun submit(
        params: Eip155SubmitParams,
        requestOptions: RequestOptions,
    ): Eip155SubmitResponse =
        // post /api/v2/accounts/{account_id}/order_requests/eip155
        withRawResponse().submit(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        Eip155Service.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): Eip155Service.WithRawResponse =
            Eip155ServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createPermitHandler: Handler<Eip155CreatePermitResponse> =
            jsonHandler<Eip155CreatePermitResponse>(clientOptions.jsonMapper)

        override fun createPermit(
            params: Eip155CreatePermitParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Eip155CreatePermitResponse> {
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
                        "order_requests",
                        "eip155",
                        "permit",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createPermitHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createPermitTransactionHandler: Handler<Eip155CreatePermitTransactionResponse> =
            jsonHandler<Eip155CreatePermitTransactionResponse>(clientOptions.jsonMapper)

        override fun createPermitTransaction(
            params: Eip155CreatePermitTransactionParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Eip155CreatePermitTransactionResponse> {
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
                        "order_requests",
                        "eip155",
                        "permit_transaction",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createPermitTransactionHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val submitHandler: Handler<Eip155SubmitResponse> =
            jsonHandler<Eip155SubmitResponse>(clientOptions.jsonMapper)

        override fun submit(
            params: Eip155SubmitParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Eip155SubmitResponse> {
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
                        "order_requests",
                        "eip155",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { submitHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
