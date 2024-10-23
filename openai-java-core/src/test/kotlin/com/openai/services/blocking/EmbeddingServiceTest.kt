// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EmbeddingServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val embeddingService = client.embeddings()
        val createEmbeddingResponse =
            embeddingService.create(
                EmbeddingCreateParams.builder()
                    .input(EmbeddingCreateParams.Input.ofString("This is a test."))
                    .model(EmbeddingCreateParams.Model.ofString("string"))
                    .dimensions(123L)
                    .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
                    .user("user-1234")
                    .build()
            )
        println(createEmbeddingResponse)
        createEmbeddingResponse.validate()
    }
}