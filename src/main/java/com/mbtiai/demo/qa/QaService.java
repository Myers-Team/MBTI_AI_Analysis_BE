package com.mbtiai.demo.qa;

import java.util.List;

public interface QaService {
    QaResponseDto saveQa(QaRequestDto requestDto);
    List<QaResponseDto> getAllQas();
    QaResponseDto getQuestionFromFlask();
    QaResponseDto sendAnswerAndGetNextQuestion(QaRequestDto requestDto);
}