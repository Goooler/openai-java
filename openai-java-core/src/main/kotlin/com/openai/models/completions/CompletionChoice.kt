// File generated from our OpenAPI spec by Stainless.

package com.openai.models.completions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@NoAutoDetect
class CompletionChoice
@JsonCreator
private constructor(
    @JsonProperty("finish_reason")
    @ExcludeMissing
    private val finishReason: JsonField<FinishReason> = JsonMissing.of(),
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("logprobs")
    @ExcludeMissing
    private val logprobs: JsonField<Logprobs> = JsonMissing.of(),
    @JsonProperty("text") @ExcludeMissing private val text: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The reason the model stopped generating tokens. This will be `stop` if the model hit a
     * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
     * specified in the request was reached, or `content_filter` if content was omitted due to a
     * flag from our content filters.
     */
    fun finishReason(): FinishReason = finishReason.getRequired("finish_reason")

    fun index(): Long = index.getRequired("index")

    fun logprobs(): Optional<Logprobs> = Optional.ofNullable(logprobs.getNullable("logprobs"))

    fun text(): String = text.getRequired("text")

    /**
     * The reason the model stopped generating tokens. This will be `stop` if the model hit a
     * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
     * specified in the request was reached, or `content_filter` if content was omitted due to a
     * flag from our content filters.
     */
    @JsonProperty("finish_reason")
    @ExcludeMissing
    fun _finishReason(): JsonField<FinishReason> = finishReason

    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<Logprobs> = logprobs

    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): CompletionChoice = apply {
        if (validated) {
            return@apply
        }

        finishReason()
        index()
        logprobs().ifPresent { it.validate() }
        text()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CompletionChoice].
         *
         * The following fields are required:
         * ```java
         * .finishReason()
         * .index()
         * .logprobs()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CompletionChoice]. */
    class Builder internal constructor() {

        private var finishReason: JsonField<FinishReason>? = null
        private var index: JsonField<Long>? = null
        private var logprobs: JsonField<Logprobs>? = null
        private var text: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completionChoice: CompletionChoice) = apply {
            finishReason = completionChoice.finishReason
            index = completionChoice.index
            logprobs = completionChoice.logprobs
            text = completionChoice.text
            additionalProperties = completionChoice.additionalProperties.toMutableMap()
        }

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, or `content_filter` if content was omitted due to a
         * flag from our content filters.
         */
        fun finishReason(finishReason: FinishReason) = finishReason(JsonField.of(finishReason))

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, or `content_filter` if content was omitted due to a
         * flag from our content filters.
         */
        fun finishReason(finishReason: JsonField<FinishReason>) = apply {
            this.finishReason = finishReason
        }

        fun index(index: Long) = index(JsonField.of(index))

        fun index(index: JsonField<Long>) = apply { this.index = index }

        fun logprobs(logprobs: Logprobs?) = logprobs(JsonField.ofNullable(logprobs))

        fun logprobs(logprobs: Optional<Logprobs>) = logprobs(logprobs.getOrNull())

        fun logprobs(logprobs: JsonField<Logprobs>) = apply { this.logprobs = logprobs }

        fun text(text: String) = text(JsonField.of(text))

        fun text(text: JsonField<String>) = apply { this.text = text }

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

        fun build(): CompletionChoice =
            CompletionChoice(
                checkRequired("finishReason", finishReason),
                checkRequired("index", index),
                checkRequired("logprobs", logprobs),
                checkRequired("text", text),
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The reason the model stopped generating tokens. This will be `stop` if the model hit a
     * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
     * specified in the request was reached, or `content_filter` if content was omitted due to a
     * flag from our content filters.
     */
    class FinishReason @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val STOP = of("stop")

            @JvmField val LENGTH = of("length")

            @JvmField val CONTENT_FILTER = of("content_filter")

            @JvmStatic fun of(value: String) = FinishReason(JsonField.of(value))
        }

        /** An enum containing [FinishReason]'s known values. */
        enum class Known {
            STOP,
            LENGTH,
            CONTENT_FILTER,
        }

        /**
         * An enum containing [FinishReason]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [FinishReason] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            STOP,
            LENGTH,
            CONTENT_FILTER,
            /**
             * An enum member indicating that [FinishReason] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                STOP -> Value.STOP
                LENGTH -> Value.LENGTH
                CONTENT_FILTER -> Value.CONTENT_FILTER
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                STOP -> Known.STOP
                LENGTH -> Known.LENGTH
                CONTENT_FILTER -> Known.CONTENT_FILTER
                else -> throw OpenAIInvalidDataException("Unknown FinishReason: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FinishReason && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    @NoAutoDetect
    class Logprobs
    @JsonCreator
    private constructor(
        @JsonProperty("text_offset")
        @ExcludeMissing
        private val textOffset: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("token_logprobs")
        @ExcludeMissing
        private val tokenLogprobs: JsonField<List<Double>> = JsonMissing.of(),
        @JsonProperty("tokens")
        @ExcludeMissing
        private val tokens: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("top_logprobs")
        @ExcludeMissing
        private val topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun textOffset(): Optional<List<Long>> =
            Optional.ofNullable(textOffset.getNullable("text_offset"))

        fun tokenLogprobs(): Optional<List<Double>> =
            Optional.ofNullable(tokenLogprobs.getNullable("token_logprobs"))

        fun tokens(): Optional<List<String>> = Optional.ofNullable(tokens.getNullable("tokens"))

        fun topLogprobs(): Optional<List<TopLogprob>> =
            Optional.ofNullable(topLogprobs.getNullable("top_logprobs"))

        @JsonProperty("text_offset")
        @ExcludeMissing
        fun _textOffset(): JsonField<List<Long>> = textOffset

        @JsonProperty("token_logprobs")
        @ExcludeMissing
        fun _tokenLogprobs(): JsonField<List<Double>> = tokenLogprobs

        @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

        @JsonProperty("top_logprobs")
        @ExcludeMissing
        fun _topLogprobs(): JsonField<List<TopLogprob>> = topLogprobs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Logprobs = apply {
            if (validated) {
                return@apply
            }

            textOffset()
            tokenLogprobs()
            tokens()
            topLogprobs().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Logprobs]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Logprobs]. */
        class Builder internal constructor() {

            private var textOffset: JsonField<MutableList<Long>>? = null
            private var tokenLogprobs: JsonField<MutableList<Double>>? = null
            private var tokens: JsonField<MutableList<String>>? = null
            private var topLogprobs: JsonField<MutableList<TopLogprob>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logprobs: Logprobs) = apply {
                textOffset = logprobs.textOffset.map { it.toMutableList() }
                tokenLogprobs = logprobs.tokenLogprobs.map { it.toMutableList() }
                tokens = logprobs.tokens.map { it.toMutableList() }
                topLogprobs = logprobs.topLogprobs.map { it.toMutableList() }
                additionalProperties = logprobs.additionalProperties.toMutableMap()
            }

            fun textOffset(textOffset: List<Long>) = textOffset(JsonField.of(textOffset))

            fun textOffset(textOffset: JsonField<List<Long>>) = apply {
                this.textOffset = textOffset.map { it.toMutableList() }
            }

            fun addTextOffset(textOffset: Long) = apply {
                this.textOffset =
                    (this.textOffset ?: JsonField.of(mutableListOf())).also {
                        checkKnown("textOffset", it).add(textOffset)
                    }
            }

            fun tokenLogprobs(tokenLogprobs: List<Double>) =
                tokenLogprobs(JsonField.of(tokenLogprobs))

            fun tokenLogprobs(tokenLogprobs: JsonField<List<Double>>) = apply {
                this.tokenLogprobs = tokenLogprobs.map { it.toMutableList() }
            }

            fun addTokenLogprob(tokenLogprob: Double) = apply {
                tokenLogprobs =
                    (tokenLogprobs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tokenLogprobs", it).add(tokenLogprob)
                    }
            }

            fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

            fun tokens(tokens: JsonField<List<String>>) = apply {
                this.tokens = tokens.map { it.toMutableList() }
            }

            fun addToken(token: String) = apply {
                tokens =
                    (tokens ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tokens", it).add(token)
                    }
            }

            fun topLogprobs(topLogprobs: List<TopLogprob>) = topLogprobs(JsonField.of(topLogprobs))

            fun topLogprobs(topLogprobs: JsonField<List<TopLogprob>>) = apply {
                this.topLogprobs = topLogprobs.map { it.toMutableList() }
            }

            fun addTopLogprob(topLogprob: TopLogprob) = apply {
                topLogprobs =
                    (topLogprobs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("topLogprobs", it).add(topLogprob)
                    }
            }

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

            fun build(): Logprobs =
                Logprobs(
                    (textOffset ?: JsonMissing.of()).map { it.toImmutable() },
                    (tokenLogprobs ?: JsonMissing.of()).map { it.toImmutable() },
                    (tokens ?: JsonMissing.of()).map { it.toImmutable() },
                    (topLogprobs ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        @NoAutoDetect
        class TopLogprob
        @JsonCreator
        private constructor(
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): TopLogprob = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [TopLogprob]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TopLogprob]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(topLogprob: TopLogprob) = apply {
                    additionalProperties = topLogprob.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                fun build(): TopLogprob = TopLogprob(additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is TopLogprob && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "TopLogprob{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Logprobs && textOffset == other.textOffset && tokenLogprobs == other.tokenLogprobs && tokens == other.tokens && topLogprobs == other.topLogprobs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(textOffset, tokenLogprobs, tokens, topLogprobs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Logprobs{textOffset=$textOffset, tokenLogprobs=$tokenLogprobs, tokens=$tokens, topLogprobs=$topLogprobs, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CompletionChoice && finishReason == other.finishReason && index == other.index && logprobs == other.logprobs && text == other.text && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(finishReason, index, logprobs, text, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompletionChoice{finishReason=$finishReason, index=$index, logprobs=$logprobs, text=$text, additionalProperties=$additionalProperties}"
}
