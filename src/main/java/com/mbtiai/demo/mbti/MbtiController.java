package com.mbtiai.demo.mbti;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mbti/result")
public class MbtiController {
    private final MbtiService mbtiService;

    public MbtiController(MbtiService mbtiService) {
        this.mbtiService = mbtiService;
    }

    @PostMapping
    public ResponseEntity<MbtiResponseDto> calculateMbti(@RequestBody MbtiRequestDto requestDto) {
        MbtiResponseDto mbti = mbtiService.calculateMbti(requestDto);
        return ResponseEntity.ok(mbti);
    }
}