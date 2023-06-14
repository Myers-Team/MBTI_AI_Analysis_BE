package com.mbtiai.demo.qa;

import com.mbtiai.demo.user.User;
import com.mbtiai.demo.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QaServiceImpl implements QaService {
    private final QaRepository qaRepository;
    private final UserRepository userRepository;

    public QaServiceImpl(QaRepository qaRepository, UserRepository userRepository) {
        this.qaRepository = qaRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public QaResponseDto createQa(QaRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. user_id: " + requestDto.getUser_id()));

        Qa qa = requestDto.toEntity(user);
        qaRepository.save(qa);

        return QaResponseDto.fromEntity(qa);
    }

    @Override
    public List<QaResponseDto> getQaList() {
        return qaRepository.findAll().stream()
                .map(QaResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}

