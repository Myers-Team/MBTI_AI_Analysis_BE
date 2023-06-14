package com.mbtiai.demo.pmbti;


import com.mbtiai.demo.user.User;
import com.mbtiai.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;



@RequiredArgsConstructor
@Service
public class PmbtiServiceImpl implements PmbtiService {
    private final WebClient.Builder webClientBuilder;
    private final UserRepository userRepository;
    private final PmbtiRepository pmbtiRepository;

    @Override
    @Transactional
    public PmbtiResponseDto calculateAndSavePmbti(PmbtiRequestDto requestDto) {
        //flask 서버 url(아무렇게 넣어놓음)
        String url = "http://localhost:5000/calculate_mbti";

        //flask서버에 POST요청을 보내고 응답받음
        PmbtiResponseDto response = webClientBuilder.build()
                .post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(PmbtiResponseDto.class)
                .block();  // block() 메소드를 사용하여 결과를 받아옴. 주의: block()은 비동기 작업을 동기 작업으로 만들어버리므로 적절히 사용해야 함.

        User user = userRepository.findById(requestDto.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + requestDto.getUser_id()));
        Pmbti pmbti = pmbtiRepository.save(requestDto.toEntity(user));
        return PmbtiResponseDto.fromEntity(pmbti);

    }

    @Override
    @Transactional(readOnly = true)
    public PmbtiResponseDto getPmbti(Long userId) {
        Pmbti pmbti = pmbtiRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        return PmbtiResponseDto.fromEntity(pmbti);
    }
}
