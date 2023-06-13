package com.mbtiai.demo.mbti;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MbtiServiceImpl implements MbtiService {
    private final WebClient.Builder webClientBuilder;

    @Override
    public MbtiResponseDto calculateMbti(MbtiRequestDto requestDto) {
        //flask 서버 url(아무렇게 넣어놓음)
        String url = "http://localhost:5000/calculate_mbti";

        //flask서버에 POST요청을 보내고 응답받음
        MbtiResponseDto response = webClientBuilder.build()
                .post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(MbtiResponseDto.class)
                .block();  // block() 메소드를 사용하여 결과를 받아옴. 주의: block()은 비동기 작업을 동기 작업으로 만들어버리므로 적절히 사용해야 함.

        //응답받은 데이터를 MBTI객체로 반환
        return response;
    }

}
