package com.mbtiai.demo.mbti;

public interface MbtiService {
    MbtiResponseDto calculateAndSaveMbti(MbtiRequestDto requestDto);

    MbtiResponseDto getMbti(Long userId);
}
