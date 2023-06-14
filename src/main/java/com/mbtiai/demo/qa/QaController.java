package com.mbtiai.demo.qa;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QaController {
    private final QaService qaService;

    @GetMapping("/stats")
    public List<QaResponseDto> getAllQas() {
        return qaService.getAllQas();
    }

    @GetMapping("/mbti/test/personal")
    public QaResponseDto getQuestionFromFlask() {
        return qaService.getQuestionFromFlask();
    }

    @PostMapping("/mbti/test/personal")
    public QaResponseDto sendAnswerAndGetNextQuestion(@RequestBody QaRequestDto requestDto) {
        return qaService.sendAnswerAndGetNextQuestion(requestDto);
    }
}

