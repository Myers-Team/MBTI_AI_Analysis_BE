package com.mbtiai.demo.dto.sign_in.response;

import com.mbtiai.demo.common.UserType;
import io.swagger.v3.oas.annotations.media.Schema;

public record SignInResponse(
        @Schema(description = "회원 이름", example = "mbti")
        String nickname,
        @Schema(description = "회원 유형", example = "USER")
        UserType type,
        String token
) {
}
