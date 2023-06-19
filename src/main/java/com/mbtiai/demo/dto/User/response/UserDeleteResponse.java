package com.mbtiai.demo.dto.User.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserDeleteResponse(
        @Schema(description = "회원 삭제 성공 여부", example = "true")
        boolean result
) {
}
