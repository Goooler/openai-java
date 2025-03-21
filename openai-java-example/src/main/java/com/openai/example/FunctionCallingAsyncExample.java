package com.openai.example;

import static com.openai.core.ObjectMappers.jsonMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.JsonObject;
import com.openai.core.JsonValue;
import com.openai.models.ChatModel;
import com.openai.models.FunctionDefinition;
import com.openai.models.FunctionParameters;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.ChatCompletionMessageToolCall;
import com.openai.models.chat.completions.ChatCompletionTool;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class FunctionCallingAsyncExample {
    private FunctionCallingAsyncExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_3_5_TURBO)
                .maxCompletionTokens(2048)
                .addTool(ChatCompletionTool.builder()
                        .function(FunctionDefinition.builder()
                                .name("get-sdk-quality")
                                .description("Gets the quality of the given SDK.")
                                .parameters(FunctionParameters.builder()
                                        .putAdditionalProperty("type", JsonValue.from("object"))
                                        .putAdditionalProperty(
                                                "properties", JsonValue.from(Map.of("name", Map.of("type", "string"))))
                                        .putAdditionalProperty("required", JsonValue.from(List.of("name")))
                                        .putAdditionalProperty("additionalProperties", JsonValue.from(false))
                                        .build())
                                .build())
                        .build())
                .addUserMessage("How good are the following SDKs: OpenAI Java SDK, Unknown Company SDK")
                .build();

        client.chat()
                .completions()
                .create(createParams)
                .thenAccept(completion -> completion.choices().stream()
                        .map(ChatCompletion.Choice::message)
                        .flatMap(message -> {
                            message.content().ifPresent(System.out::println);
                            return message.toolCalls().stream().flatMap(Collection::stream);
                        })
                        .forEach(toolCall -> System.out.println(callFunction(toolCall.function()))))
                .join();
    }

    private static String callFunction(ChatCompletionMessageToolCall.Function function) {
        if (!function.name().equals("get-sdk-quality")) {
            throw new IllegalArgumentException("Unknown function: " + function.name());
        }

        JsonValue arguments;
        try {
            arguments = JsonValue.from(jsonMapper().readTree(function.arguments()));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Bad function arguments", e);
        }

        String sdkName = ((JsonObject) arguments).values().get("name").asStringOrThrow();
        if (sdkName.contains("OpenAI")) {
            return sdkName + ": It's robust and polished!";
        }

        return sdkName + ": *shrug*";
    }
}
