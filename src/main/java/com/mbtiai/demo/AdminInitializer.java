package com.mbtiai.demo;

import com.mbtiai.demo.common.UserType;
import com.mbtiai.demo.entity.User;
import com.mbtiai.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class AdminInitializer implements ApplicationRunner {
    private final UserRepository memberRepository;
    private final PasswordEncoder encoder;	// 추가

    @Override
    public void run(ApplicationArguments args) {
        memberRepository.save(User.builder()
                .account("admin")
                .password(encoder.encode("admin"))	// 수정
                .nickname("관리자")
                .type(UserType.ADMIN)
                .createdAt(LocalDateTime.now())
                .build());
    }
}
