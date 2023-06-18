package com.mbtiai.demo.qa;

import com.mbtiai.demo.user.User;
import com.mbtiai.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class QaServiceImpl implements QaService {

    private final WebClient.Builder webClientBuilder;
    private final UserRepository userRepository;
    private final QaRepository qaRepository;

    @Autowired
    public QaServiceImpl(UserRepository userRepository, QaRepository qaRepository, WebClient.Builder webClientBuilder) {
        this.userRepository = userRepository;
        this.qaRepository = qaRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    @Transactional
    public QaResponseDto saveQa(QaRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + requestDto.getUser_id()));
        Qa qa = qaRepository.save(requestDto.toEntity(user));
        return QaResponseDto.fromEntity(qa);
    }

    @Override
    public QaResponseDto getQuestionFromFlask() {
        String url = "http://203.253.21.178:5000/question"; // Flask server's URL to get the question
        QaResponseDto response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(QaResponseDto.class)
                .block();
        return response;
    }

    @Override
    public QaResponseDto sendAnswerAndGetNextQuestion(QaRequestDto requestDto) {
        // Send user's answer to Flask server
        String evaluateUrl = "http://203.253.21.178:5000/evaluateandquestion";
        webClientBuilder.build()
                .post()
                .uri(evaluateUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        // Save the current question, answer, emd_v, and user_id to the database
        User user = userRepository.findById(requestDto.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + requestDto.getUser_id()));
        Qa qa = requestDto.toEntity(user);
        qaRepository.save(qa);

        // After sending the answer, get the next question
        String questionUrl = "http://203.253.21.178:5000/question";
        QaResponseDto response = webClientBuilder.build()
                .get()
                .uri(questionUrl)
                .retrieve()
                .bodyToMono(QaResponseDto.class)
                .block();

        return response;
    }

    //df
    @Override
    public List<QaResponseDto> getAllQas() {
        List<Qa> qas = qaRepository.findAll();
        return qas.stream().map(QaResponseDto::fromEntity).collect(Collectors.toList());
    }
}

// getQuestionFromFlask 메서드에서는 Flask 서버의 /mbti/test/personal 엔드포인트로 GET 요청을 보내어 질문을 받아옵니다.
//
// sendAnswerAndGetNextQuestion 메서드에서는 사용자의 답변을 Flask 서버로 POST 요청을 보내고, 그 후에 GET 요청을 보내 다음 질문을 받아옵니다.
//
// saveQa 메서드는 사용자의 답변을 데이터베이스에 저장하는 역할을 합니다.
//
// getAllQas 메서드는 데이터베이스에 저장된 모든 질문과 답변을 불러옵니다.

