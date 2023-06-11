package com.mbtiai.demo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
public class UserSignUpRequestDto {
    @NotBlank(message = "ID")
    private String email;

    @NotBlank(message = "password")
    @Pattern(regexp = "^(?=.*[A-za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-za-z\\d@$!%*#?&]{8,30}$",
    message = "error : 비밀번호는 8~30 중 1개 이상의 알파벳과 숫자, 특수문자를 포함해야 합니다.")
    private String password;

    @NotBlank(message = "닉네임")
    @Size(min = 1, message = "error : 비밀번호가 너무 짧습니다")
    private String nickname;

   // private String checkedPassword;
    @Builder
    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
