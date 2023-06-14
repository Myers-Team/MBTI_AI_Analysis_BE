package com.mbtiai.demo.pmbti;


public interface PmbtiService {
    PmbtiResponseDto calculateAndSavePmbti(PmbtiRequestDto requestDto);
    PmbtiResponseDto getPmbti(Long userId);
}
