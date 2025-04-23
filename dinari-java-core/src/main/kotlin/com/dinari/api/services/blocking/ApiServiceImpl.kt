// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking

import com.dinari.api.core.ClientOptions
import com.dinari.api.services.blocking.api.V2Service
import com.dinari.api.services.blocking.api.V2ServiceImpl

class ApiServiceImpl internal constructor(private val clientOptions: ClientOptions) : ApiService {

    private val withRawResponse: ApiService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val v2: V2Service by lazy { V2ServiceImpl(clientOptions) }

    override fun withRawResponse(): ApiService.WithRawResponse = withRawResponse

    override fun v2(): V2Service = v2

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ApiService.WithRawResponse {

        private val v2: V2Service.WithRawResponse by lazy {
            V2ServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun v2(): V2Service.WithRawResponse = v2
    }
}
