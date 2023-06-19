package com.mbtiai.demo.dto.User.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserUpdateRequest(
        @Schema(description = "회원 비밀번호", example = "1234")
        String password,
        @Schema(description = "회원 새 비밀번호", example = "1234")
        String newPassword,
        @Schema(description = "회원 이름", example = "mbti")
        String name
) {
}
