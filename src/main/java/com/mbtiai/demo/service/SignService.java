package com.mbtiai.demo.service;

import com.mbtiai.demo.dto.sign_in.request.SignInRequest;
import com.mbtiai.demo.dto.sign_in.response.SignInResponse;
import com.mbtiai.demo.dto.sign_up.request.SignUpRequest;
import com.mbtiai.demo.dto.sign_up.response.SignUpResponse;
import com.mbtiai.demo.entity.User;
import com.mbtiai.demo.repository.UserRepository;
import com.mbtiai.demo.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignService {
    private final UserRepository memberRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder encoder;	// 추가

    @Transactional
    public SignUpResponse registMember(SignUpRequest request) {
        User member = memberRepository.save(User.from(request, encoder));	// 회원가입 정보를 암호화하도록 수정
        try {
            memberRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        return SignUpResponse.from(member);
    }

    @Transactional(readOnly = true)
    public SignInResponse signIn(SignInRequest request) {
        User member = memberRepository.findByAccount(request.account())
                .filter(it -> it.getPassword().equals(request.password()))	// 암호화된 비밀번호와 비교하도록 수정
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
        String token = tokenProvider.createToken(String.format("%s:%s", member.getId(), member.getType()));
        return new SignInResponse(member.getNickname(), member.getType(), token);
    }
}
