package com.noinping.halmang_api.domain.claude.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.ai.chat.model.ChatResponse;

public record CardNews(
        @Schema(description = "카드뉴스")
        ChatResponse chatResponse
) {
}
