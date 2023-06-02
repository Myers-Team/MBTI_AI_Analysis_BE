package com.mbtiai.demo.pmbti;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PmbtiServiceImpl implements PmbtiService {
    private final RestTemplate restTemplate;
    @Override
    public PmbtiResponseDto calculatePmbti(PmbtiRequestDto requestDto) {
        String url = "http://localhost:5000/calculate_pmbti";
        HttpEntity<PmbtiRequestDto> request = new HttpEntity<>(requestDto);
        ResponseEntity<PmbtiResponseDto> response = restTemplate.postForEntity(url, request, PmbtiResponseDto.class);
        return response.getBody();
    }
}
