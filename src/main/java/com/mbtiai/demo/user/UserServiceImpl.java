package com.mbtiai.demo.user;

import com.mbtiai.demo.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Long signUp(UserSignUpRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다");
        }
//        if(!requestDto.getPassword().equals(requestDto.getCheckedPassword())){
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }

        User user = userRepository.save(requestDto.toEntity());
        user.encodePassword(passwordEncoder);
        user.addUserAuthority();
        return user.getUser_id();
    }

    @Transactional
    @Override
    public String signin(UserSignInRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입된 이메일이 아닙니다."));
//        validateMatchedPassword(requestDto.getPassword(), user.getPassword());

        String role = user.getRole().name();
        return jwtTokenProvider.createToken(user.getUsername(), role);
    }
}


