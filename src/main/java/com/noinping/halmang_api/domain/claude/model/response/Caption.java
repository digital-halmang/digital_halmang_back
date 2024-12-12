package com.noinping.halmang_api.domain.claude.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.ai.chat.model.ChatResponse;

public record Caption (
        @Schema(description = "캡션 응답")
        ChatResponse caption) {
}
