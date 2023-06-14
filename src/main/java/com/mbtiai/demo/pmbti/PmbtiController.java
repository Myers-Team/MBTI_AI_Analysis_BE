package com.mbtiai.demo.pmbti;

import com.mbtiai.demo.mbti.MbtiRequestDto;
import com.mbtiai.demo.mbti.MbtiResponseDto;
import com.mbtiai.demo.mbti.MbtiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pmbti")   //임시로
public class PmbtiController {

    private final PmbtiService pmbtiService;

    @PostMapping("/calculate")
    public PmbtiResponseDto calculateAndSaveMbti(@RequestBody PmbtiRequestDto requestDto) {
        return pmbtiService.calculateAndSavePmbti(requestDto);
    }

    @GetMapping("/result/{userId}")
    public PmbtiResponseDto getPmbtiResult(@PathVariable Long userId) {
        return pmbtiService.getPmbti(userId);
    }
}

