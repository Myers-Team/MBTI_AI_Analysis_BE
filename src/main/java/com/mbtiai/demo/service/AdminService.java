package com.mbtiai.demo.service;

import com.mbtiai.demo.common.UserType;
import com.mbtiai.demo.dto.User.response.UserInfoResponse;
import com.mbtiai.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final UserRepository memberRepository;

    @Transactional(readOnly = true)
    public List<UserInfoResponse> getMembers() {
        return memberRepository.findAllByType(UserType.USER).stream()
                .map(UserInfoResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<UserInfoResponse> getAdmins() {
        return memberRepository.findAllByType(UserType.ADMIN).stream()
                .map(UserInfoResponse::from)
                .toList();
    }
}
