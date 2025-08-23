// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * A news article relating to a `Stock` which includes a summary of the article and a link to the
 * original source.
 */
class StockRetrieveNewsResponse
private constructor(
    private val articleUrl: JsonField<String>,
    private val description: JsonField<String>,
    private val imageUrl: JsonField<String>,
    private val publishedDt: JsonField<OffsetDateTime>,
    private val publisher: JsonField<String>,
    private val ampUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("article_url")
        @ExcludeMissing
        articleUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("image_url") @ExcludeMissing imageUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("published_dt")
        @ExcludeMissing
        publishedDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("publisher") @ExcludeMissing publisher: JsonField<String> = JsonMissing.of(),
        @JsonProperty("amp_url") @ExcludeMissing ampUrl: JsonField<String> = JsonMissing.of(),
    ) : this(articleUrl, description, imageUrl, publishedDt, publisher, ampUrl, mutableMapOf())

    /**
     * URL of the news article
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun articleUrl(): String = articleUrl.getRequired("article_url")

    /**
     * Description of the news article
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun description(): String = description.getRequired("description")

    /**
     * URL of the image for the news article
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun imageUrl(): String = imageUrl.getRequired("image_url")

    /**
     * Datetime when the article was published. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun publishedDt(): OffsetDateTime = publishedDt.getRequired("published_dt")

    /**
     * The publisher of the news article
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun publisher(): String = publisher.getRequired("publisher")

    /**
     * Mobile-friendly Accelerated Mobile Page (AMP) URL of the news article, if available
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ampUrl(): Optional<String> = ampUrl.getOptional("amp_url")

    /**
     * Returns the raw JSON value of [articleUrl].
     *
     * Unlike [articleUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("article_url") @ExcludeMissing fun _articleUrl(): JsonField<String> = articleUrl

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [imageUrl].
     *
     * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image_url") @ExcludeMissing fun _imageUrl(): JsonField<String> = imageUrl

    /**
     * Returns the raw JSON value of [publishedDt].
     *
     * Unlike [publishedDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("published_dt")
    @ExcludeMissing
    fun _publishedDt(): JsonField<OffsetDateTime> = publishedDt

    /**
     * Returns the raw JSON value of [publisher].
     *
     * Unlike [publisher], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("publisher") @ExcludeMissing fun _publisher(): JsonField<String> = publisher

    /**
     * Returns the raw JSON value of [ampUrl].
     *
     * Unlike [ampUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amp_url") @ExcludeMissing fun _ampUrl(): JsonField<String> = ampUrl

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [StockRetrieveNewsResponse].
         *
         * The following fields are required:
         * ```java
         * .articleUrl()
         * .description()
         * .imageUrl()
         * .publishedDt()
         * .publisher()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StockRetrieveNewsResponse]. */
    class Builder internal constructor() {

        private var articleUrl: JsonField<String>? = null
        private var description: JsonField<String>? = null
        private var imageUrl: JsonField<String>? = null
        private var publishedDt: JsonField<OffsetDateTime>? = null
        private var publisher: JsonField<String>? = null
        private var ampUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(stockRetrieveNewsResponse: StockRetrieveNewsResponse) = apply {
            articleUrl = stockRetrieveNewsResponse.articleUrl
            description = stockRetrieveNewsResponse.description
            imageUrl = stockRetrieveNewsResponse.imageUrl
            publishedDt = stockRetrieveNewsResponse.publishedDt
            publisher = stockRetrieveNewsResponse.publisher
            ampUrl = stockRetrieveNewsResponse.ampUrl
            additionalProperties = stockRetrieveNewsResponse.additionalProperties.toMutableMap()
        }

        /** URL of the news article */
        fun articleUrl(articleUrl: String) = articleUrl(JsonField.of(articleUrl))

        /**
         * Sets [Builder.articleUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.articleUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun articleUrl(articleUrl: JsonField<String>) = apply { this.articleUrl = articleUrl }

        /** Description of the news article */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** URL of the image for the news article */
        fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

        /**
         * Sets [Builder.imageUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

        /** Datetime when the article was published. ISO 8601 timestamp. */
        fun publishedDt(publishedDt: OffsetDateTime) = publishedDt(JsonField.of(publishedDt))

        /**
         * Sets [Builder.publishedDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.publishedDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun publishedDt(publishedDt: JsonField<OffsetDateTime>) = apply {
            this.publishedDt = publishedDt
        }

        /** The publisher of the news article */
        fun publisher(publisher: String) = publisher(JsonField.of(publisher))

        /**
         * Sets [Builder.publisher] to an arbitrary JSON value.
         *
         * You should usually call [Builder.publisher] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun publisher(publisher: JsonField<String>) = apply { this.publisher = publisher }

        /** Mobile-friendly Accelerated Mobile Page (AMP) URL of the news article, if available */
        fun ampUrl(ampUrl: String) = ampUrl(JsonField.of(ampUrl))

        /**
         * Sets [Builder.ampUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ampUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ampUrl(ampUrl: JsonField<String>) = apply { this.ampUrl = ampUrl }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [StockRetrieveNewsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .articleUrl()
         * .description()
         * .imageUrl()
         * .publishedDt()
         * .publisher()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StockRetrieveNewsResponse =
            StockRetrieveNewsResponse(
                checkRequired("articleUrl", articleUrl),
                checkRequired("description", description),
                checkRequired("imageUrl", imageUrl),
                checkRequired("publishedDt", publishedDt),
                checkRequired("publisher", publisher),
                ampUrl,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StockRetrieveNewsResponse = apply {
        if (validated) {
            return@apply
        }

        articleUrl()
        description()
        imageUrl()
        publishedDt()
        publisher()
        ampUrl()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: DinariInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (articleUrl.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (imageUrl.asKnown().isPresent) 1 else 0) +
            (if (publishedDt.asKnown().isPresent) 1 else 0) +
            (if (publisher.asKnown().isPresent) 1 else 0) +
            (if (ampUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StockRetrieveNewsResponse &&
            articleUrl == other.articleUrl &&
            description == other.description &&
            imageUrl == other.imageUrl &&
            publishedDt == other.publishedDt &&
            publisher == other.publisher &&
            ampUrl == other.ampUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            articleUrl,
            description,
            imageUrl,
            publishedDt,
            publisher,
            ampUrl,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StockRetrieveNewsResponse{articleUrl=$articleUrl, description=$description, imageUrl=$imageUrl, publishedDt=$publishedDt, publisher=$publisher, ampUrl=$ampUrl, additionalProperties=$additionalProperties}"
}
