package com.mbtiai.demo.mbti;

import com.mbtiai.demo.user.User;
import com.mbtiai.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@RequiredArgsConstructor
//@Transactional    -> read0nly못씀
@Service
public class MbtiServiceImpl implements MbtiService {
    private final WebClient.Builder webClientBuilder;
    private final UserRepository userRepository;
    private final MbtiRepository mbtiRepository;

    @Override
    @Transactional
    public MbtiResponseDto calculateAndSaveMbti(MbtiRequestDto requestDto) {
        // flask 서버 url(아무렇게 넣어놓음)
        String url = "http://203.253.21.178:5000/evaluatelast";

        MbtiResponseDto response = webClientBuilder.build()
                .post() // Change get to post
                .uri(url)
                .bodyValue(requestDto)  // Add this line to include request body
                .retrieve()
                .bodyToMono(MbtiResponseDto.class)
                .block();

        // 응답받은 데이터를 MBTI객체로 저장
        User user = userRepository.findById(requestDto.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + requestDto.getUser_id()));
        Mbti mbti = mbtiRepository.save(requestDto.toEntity(user));
        return MbtiResponseDto.fromEntity(mbti);
    }
    @Override
    @Transactional(readOnly = true)
    public MbtiResponseDto getMbti(Long userId) {
        Mbti mbti = mbtiRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        return MbtiResponseDto.fromEntity(mbti);
    }
}
