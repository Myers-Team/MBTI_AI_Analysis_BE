package com.mbtiai.demo.service;

import com.mbtiai.demo.dto.User.request.UserUpdateRequest;
import com.mbtiai.demo.dto.User.response.UserDeleteResponse;
import com.mbtiai.demo.dto.User.response.UserInfoResponse;
import com.mbtiai.demo.dto.User.response.UserUpdateResponse;
import com.mbtiai.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Transactional(readOnly = true)
    public UserInfoResponse getUserInfo(UUID id) {
        return userRepository.findById(id)
                .map(UserInfoResponse::from)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }

    @Transactional
    public UserDeleteResponse deleteUser(UUID id) {
        if (!userRepository.existsById(id)) return new UserDeleteResponse(false);
        userRepository.deleteById(id);
        return new UserDeleteResponse(true);
    }

    @Transactional
    public UserUpdateResponse updateUser(UUID id, UserUpdateRequest request) {
        return userRepository.findById(id)
                .filter(user -> encoder.matches(request.password(), user.getPassword()))	// 암호화된 비밀번호와 비교하도록 수정
                .map(user -> {
                    user.update(request, encoder);	// 새 비밀번호를 암호화하도록 수정
                    return UserUpdateResponse.of(true, user);
                })
                .orElseThrow(() -> new NoSuchElementException("아이디 또는 비밀번호가 일치하지 않습니다."));
    }
}
