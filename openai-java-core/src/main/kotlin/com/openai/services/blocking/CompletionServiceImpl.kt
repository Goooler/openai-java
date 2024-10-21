// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.map
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.StreamResponse
import com.openai.core.json
import com.openai.errors.OpenAIError
import com.openai.models.Completion
import com.openai.models.CompletionCreateParams

class CompletionServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CompletionService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Completion> =
        jsonHandler<Completion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a completion for the provided prompt and parameters. */
    override fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions
    ): Completion {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("completions")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val createStreamingHandler: Handler<StreamResponse<Completion>> =
        sseHandler().mapJson<Completion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a completion for the provided prompt and parameters. */
    override fun createStreaming(
        params: CompletionCreateParams,
        requestOptions: RequestOptions
    ): StreamResponse<Completion> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("completions")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(
                    json(
                        clientOptions.jsonMapper,
                        params
                            .getBody()
                            .toBuilder()
                            .putAdditionalProperty("stream", JsonValue.from(true))
                            .build()
                    )
                )
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { createStreamingHandler.handle(it) }
                .let { streamingResponse ->
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        streamingResponse.map { it.validate() }
                    } else {
                        streamingResponse
                    }
                }
        }
    }
}