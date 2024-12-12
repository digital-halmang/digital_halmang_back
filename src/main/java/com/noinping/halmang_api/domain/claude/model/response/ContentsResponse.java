package com.noinping.halmang_api.domain.claude.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ContentsResponse(
        @Schema(description = "블로그")
        Blog blog,
        @Schema(description = "카드뉴스")
        CardNews cardNews,
        @Schema(description = "캡션")
        Caption caption
) {
}
