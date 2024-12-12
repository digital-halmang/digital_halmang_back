package com.noinping.halmang_api.domain.cofig;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.anthropic.AnthropicChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.anthropic.api.AnthropicApi;

@Configuration
public class ClaudeConfig {

    @Value("${spring.ai.anthropic.api-key}")
    private String apiKey;

    @Bean
    public AnthropicApi anthropicApi() {
        return new AnthropicApi(apiKey);
    }

    @Bean
    public AnthropicChatModel chatModel(AnthropicApi anthropicApi) {
        return new AnthropicChatModel(anthropicApi,
                AnthropicChatOptions.builder()
                        .withModel("claude-3-opus-20240229")
                        .withTemperature(0.4)
                        .withMaxTokens(2000)
                        .build());
    }
}
