package com.mbtiai.demo.entity;

import com.mbtiai.demo.common.UserType;
import com.mbtiai.demo.dto.User.request.UserUpdateRequest;
import com.mbtiai.demo.dto.sign_up.request.SignUpRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class User {

    @Column(nullable = false, unique = true)
    private String account;
    @Column(nullable = false)
    private String password;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private LocalDateTime createdAt;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public static User from(SignUpRequest request, PasswordEncoder encoder) {	// 파라미터에 PasswordEncoder 추가
        return User.builder()
                .account(request.account())
                .password(encoder.encode(request.password()))	// 수정
                .nickname(request.nickname())
                .type(UserType.USER)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public void update(UserUpdateRequest newMember, PasswordEncoder encoder) {	// 파라미터에 PasswordEncoder 추가
        this.password = newMember.newPassword() == null || newMember.newPassword().isBlank()
                ? this.password : encoder.encode(newMember.newPassword());	// 수정
        this.nickname = newMember.name();
    }
}
