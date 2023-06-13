package com.mbtiai.demo.pmbti;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PmbtiServiceImpl implements PmbtiService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String communicateWithFlaskServer(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) {
        ResponseEntity<T> response = restTemplate.exchange(url, method, requestEntity, responseType);
        return response.getBody();
    }
}
