// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.entities.kyc

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.MultipartField
import com.dinari.api.core.Params
import com.dinari.api.core.checkRequired
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.InputStream
import java.nio.file.Path
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name
import kotlin.jvm.optionals.getOrNull

/**
 * Upload KYC-related documentation for partners that are provisioned to provide their own KYC data.
 */
class KycUploadDocumentParams
private constructor(
    private val entityId: String,
    private val kycId: String?,
    private val documentType: KycDocumentType,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun entityId(): String = entityId

    fun kycId(): Optional<String> = Optional.ofNullable(kycId)

    /** Type of `KYCDocument` to be uploaded. */
    fun documentType(): KycDocumentType = documentType

    /**
     * File to be uploaded. Must be a valid image or PDF file (jpg, jpeg, png, pdf) less than 10MB
     * in size.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun file(): InputStream = body.file()

    /**
     * Returns the raw multipart value of [file].
     *
     * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _file(): MultipartField<InputStream> = body._file()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [KycUploadDocumentParams].
         *
         * The following fields are required:
         * ```java
         * .entityId()
         * .documentType()
         * .file()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [KycUploadDocumentParams]. */
    class Builder internal constructor() {

        private var entityId: String? = null
        private var kycId: String? = null
        private var documentType: KycDocumentType? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(kycUploadDocumentParams: KycUploadDocumentParams) = apply {
            entityId = kycUploadDocumentParams.entityId
            kycId = kycUploadDocumentParams.kycId
            documentType = kycUploadDocumentParams.documentType
            body = kycUploadDocumentParams.body.toBuilder()
            additionalHeaders = kycUploadDocumentParams.additionalHeaders.toBuilder()
            additionalQueryParams = kycUploadDocumentParams.additionalQueryParams.toBuilder()
        }

        fun entityId(entityId: String) = apply { this.entityId = entityId }

        fun kycId(kycId: String?) = apply { this.kycId = kycId }

        /** Alias for calling [Builder.kycId] with `kycId.orElse(null)`. */
        fun kycId(kycId: Optional<String>) = kycId(kycId.getOrNull())

        /** Type of `KYCDocument` to be uploaded. */
        fun documentType(documentType: KycDocumentType) = apply { this.documentType = documentType }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [file]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * File to be uploaded. Must be a valid image or PDF file (jpg, jpeg, png, pdf) less than
         * 10MB in size.
         */
        fun file(file: InputStream) = apply { body.file(file) }

        /**
         * Sets [Builder.file] to an arbitrary multipart value.
         *
         * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun file(file: MultipartField<InputStream>) = apply { body.file(file) }

        /**
         * File to be uploaded. Must be a valid image or PDF file (jpg, jpeg, png, pdf) less than
         * 10MB in size.
         */
        fun file(file: ByteArray) = apply { body.file(file) }

        /**
         * File to be uploaded. Must be a valid image or PDF file (jpg, jpeg, png, pdf) less than
         * 10MB in size.
         */
        fun file(file: Path) = apply { body.file(file) }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [KycUploadDocumentParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .entityId()
         * .documentType()
         * .file()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): KycUploadDocumentParams =
            KycUploadDocumentParams(
                checkRequired("entityId", entityId),
                kycId,
                checkRequired("documentType", documentType),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> = mapOf("file" to _file()).toImmutable()

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> entityId
            1 -> kycId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("document_type", documentType.toString())
                putAll(additionalQueryParams)
            }
            .build()

    /** File input for uploading a `KYCDocument`. */
    class Body private constructor(private val file: MultipartField<InputStream>) {

        /**
         * File to be uploaded. Must be a valid image or PDF file (jpg, jpeg, png, pdf) less than
         * 10MB in size.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * Returns the raw multipart value of [file].
         *
         * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<InputStream> = file

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .file()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var file: MultipartField<InputStream>? = null

            @JvmSynthetic internal fun from(body: Body) = apply { file = body.file }

            /**
             * File to be uploaded. Must be a valid image or PDF file (jpg, jpeg, png, pdf) less
             * than 10MB in size.
             */
            fun file(file: InputStream) = file(MultipartField.of(file))

            /**
             * Sets [Builder.file] to an arbitrary multipart value.
             *
             * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /**
             * File to be uploaded. Must be a valid image or PDF file (jpg, jpeg, png, pdf) less
             * than 10MB in size.
             */
            fun file(file: ByteArray) = file(file.inputStream())

            /**
             * File to be uploaded. Must be a valid image or PDF file (jpg, jpeg, png, pdf) less
             * than 10MB in size.
             */
            fun file(file: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(file.inputStream())
                        .filename(file.name)
                        .build()
                )

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .file()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body = Body(checkRequired("file", file))
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: DinariInvalidDataException) {
                false
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && file == other.file /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{file=$file}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is KycUploadDocumentParams && entityId == other.entityId && kycId == other.kycId && documentType == other.documentType && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(entityId, kycId, documentType, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "KycUploadDocumentParams{entityId=$entityId, kycId=$kycId, documentType=$documentType, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
