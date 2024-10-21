// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionContentPartInputAudioTest {

    @Test
    fun createChatCompletionContentPartInputAudio() {
        val chatCompletionContentPartInputAudio =
            ChatCompletionContentPartInputAudio.builder()
                .inputAudio(
                    ChatCompletionContentPartInputAudio.InputAudio.builder()
                        .data("data")
                        .format(ChatCompletionContentPartInputAudio.InputAudio.Format.WAV)
                        .build()
                )
                .type(ChatCompletionContentPartInputAudio.Type.INPUT_AUDIO)
                .build()
        assertThat(chatCompletionContentPartInputAudio).isNotNull
        assertThat(chatCompletionContentPartInputAudio.inputAudio())
            .isEqualTo(
                ChatCompletionContentPartInputAudio.InputAudio.builder()
                    .data("data")
                    .format(ChatCompletionContentPartInputAudio.InputAudio.Format.WAV)
                    .build()
            )
        assertThat(chatCompletionContentPartInputAudio.type())
            .isEqualTo(ChatCompletionContentPartInputAudio.Type.INPUT_AUDIO)
    }
}