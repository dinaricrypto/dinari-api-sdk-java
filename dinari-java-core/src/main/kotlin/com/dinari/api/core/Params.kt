package com.dinari.api.core

import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams

/** An interface representing parameters passed to a service method. */
interface Params {
    /** The full set of headers in the parameters, including both fixed and additional headers. */
    fun _headers(): Headers

    /**
     * The full set of query params in the parameters, including both fixed and additional query
     * params.
     */
    fun _queryParams(): QueryParams
}
