package com.mbtiai.demo.dto.User.response;

import com.mbtiai.demo.common.UserType;
import com.mbtiai.demo.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserInfoResponse(
        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
        UUID id,
        @Schema(description = "회원 아이디", example = "mbti1234@gmail.com")
        String account,
        @Schema(description = "회원 이름", example = "mbti")
        String name,
        @Schema(description = "회원 타입", example = "USER")
        UserType type,
        @Schema(description = "회원 생성일", example = "2023-06-19T16:00:00")
        LocalDateTime createdAt
) {
    public static UserInfoResponse from(User user) {
        return new UserInfoResponse(
                user.getId(),
                user.getAccount(),
                user.getNickname(),
                user.getType(),
                user.getCreatedAt()
        );
    }
}
