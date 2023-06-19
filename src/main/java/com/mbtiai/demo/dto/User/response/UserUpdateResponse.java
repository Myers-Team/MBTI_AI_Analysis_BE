package com.mbtiai.demo.dto.User.response;

import com.mbtiai.demo.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserUpdateResponse(
        @Schema(description = "회원 정보 수정 성공 여부", example = "true")
        boolean result,
        @Schema(description = "회원 이름", example = "mbti")
        String name
) {
    public static UserUpdateResponse of(boolean result, User user) {
        return new UserUpdateResponse(result, user.getNickname());
    }
}
