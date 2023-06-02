package com.mbtiai.demo.mbti;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MbtiServiceImpl implements MbtiService {
    private final RestTemplate restTemplate;

    @Override
    public MbtiResponseDto calculateMbti(MbtiRequestDto requestDto) {
        //flask 서버 url(아무렇게 넣어놓음)
        String url = "http://localhost:5000/calculate_mbti";

        //flask서버에 보낼 데이터 설정
        HttpEntity<MbtiRequestDto> request = new HttpEntity<>(requestDto);

        //flask서버에 POST요청을 보내고 응답받음
        ResponseEntity<MbtiResponseDto> response = restTemplate.postForEntity(url, request, MbtiResponseDto.class);

        //응답받은 데이터를 MBTI객체로 반환
        return response.getBody();
    }

}
