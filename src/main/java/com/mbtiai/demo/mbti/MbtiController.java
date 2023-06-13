package com.mbtiai.demo.mbti;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mbti")
public class MbtiController {

    private final MbtiService mbtiService;

    @PostMapping("/calculate")
    public MbtiResponseDto calculateAndSaveMbti(@RequestBody MbtiRequestDto requestDto) {
        return mbtiService.calculateAndSaveMbti(requestDto);
    }

    @GetMapping("/result/{userId}")
    public MbtiResponseDto getMbtiResult(@PathVariable Long userId) {
        return mbtiService.getMbti(userId);
    }
}