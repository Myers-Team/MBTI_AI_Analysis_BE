package com.mbtiai.demo.qa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QaController {
    private final QaService qaService;

    public QaController(QaService qaService) {
        this.qaService = qaService;
    }

    @PostMapping("/mbti/test/personal")
    public ResponseEntity<QaResponseDto> createQa(@RequestBody QaRequestDto requestDto) {
        return ResponseEntity.ok(qaService.createQa(requestDto));
    }

    @GetMapping("/stats")
    public ResponseEntity<List<QaResponseDto>> getQaList() {
        return ResponseEntity.ok(qaService.getQaList());
    }
}