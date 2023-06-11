package com.mbtiai.demo.user;

import lombok.Getter;

@Getter
public class UserSignUPResponseDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;

    public void UserSignUpResponseDto(User user) {
        this.id = user.getUser_id();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
    }
}