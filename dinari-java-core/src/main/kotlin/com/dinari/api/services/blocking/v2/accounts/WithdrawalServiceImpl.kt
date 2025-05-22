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
import com.dinari.api.models.v2.accounts.withdrawals.Withdrawal
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalListParams
import com.dinari.api.models.v2.accounts.withdrawals.WithdrawalRetrieveParams
import kotlin.jvm.optionals.getOrNull

class WithdrawalServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WithdrawalService {

    private val withRawResponse: WithdrawalService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WithdrawalService.WithRawResponse = withRawResponse

    override fun retrieve(
        params: WithdrawalRetrieveParams,
        requestOptions: RequestOptions,
    ): Withdrawal =
        // get /api/v2/accounts/{account_id}/withdrawals/{withdrawal_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: WithdrawalListParams,
        requestOptions: RequestOptions,
    ): List<Withdrawal> =
        // get /api/v2/accounts/{account_id}/withdrawals
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WithdrawalService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<Withdrawal> =
            jsonHandler<Withdrawal>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: WithdrawalRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Withdrawal> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("withdrawalId", params.withdrawalId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "api",
                        "v2",
                        "accounts",
                        params._pathParam(0),
                        "withdrawals",
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

        private val listHandler: Handler<List<Withdrawal>> =
            jsonHandler<List<Withdrawal>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: WithdrawalListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Withdrawal>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("accountId", params.accountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("api", "v2", "accounts", params._pathParam(0), "withdrawals")
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
