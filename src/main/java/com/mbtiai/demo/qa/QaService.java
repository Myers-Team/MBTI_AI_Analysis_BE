package com.mbtiai.demo.qa;

import java.util.List;

public interface QaService {
    QaResponseDto createQa(QaRequestDto requestDto);
    List<QaResponseDto> getQaList();
}