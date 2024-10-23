// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageGenerateParamsTest {

    @Test
    fun createImageGenerateParams() {
        ImageGenerateParams.builder()
            .prompt("A cute baby sea otter")
            .model(ImageGenerateParams.Model.ofString("string"))
            .n(10L)
            .quality(ImageGenerateParams.Quality.STANDARD)
            .responseFormat(ImageGenerateParams.ResponseFormat.URL)
            .size(ImageGenerateParams.Size._256X256)
            .style(ImageGenerateParams.Style.VIVID)
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ImageGenerateParams.builder()
                .prompt("A cute baby sea otter")
                .model(ImageGenerateParams.Model.ofString("string"))
                .n(10L)
                .quality(ImageGenerateParams.Quality.STANDARD)
                .responseFormat(ImageGenerateParams.ResponseFormat.URL)
                .size(ImageGenerateParams.Size._256X256)
                .style(ImageGenerateParams.Style.VIVID)
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.prompt()).isEqualTo("A cute baby sea otter")
        assertThat(body.model()).isEqualTo(ImageGenerateParams.Model.ofString("string"))
        assertThat(body.n()).isEqualTo(10L)
        assertThat(body.quality()).isEqualTo(ImageGenerateParams.Quality.STANDARD)
        assertThat(body.responseFormat()).isEqualTo(ImageGenerateParams.ResponseFormat.URL)
        assertThat(body.size()).isEqualTo(ImageGenerateParams.Size._256X256)
        assertThat(body.style()).isEqualTo(ImageGenerateParams.Style.VIVID)
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = ImageGenerateParams.builder().prompt("A cute baby sea otter").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.prompt()).isEqualTo("A cute baby sea otter")
    }
}