package com.mbtiai.demo.mbti;

import com.mbtiai.demo.user.User;
import com.mbtiai.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@RequiredArgsConstructor
//@Transactional    -> read0nly못씀
@Service
public class MbtiServiceImpl implements MbtiService {
    private final WebClient.Builder webClientBuilder;
    private final UserRepository userRepository;
    private final MbtiRepository mbtiRepository;

    @Override
    @Transactional
    public MbtiResponseDto calculateAndSaveMbti(MbtiRequestDto requestDto) {
        //flask 서버 url(아무렇게 넣어놓음)
        String url = "최종 수치 받아오는 링크";

        //flask서버에 POST요청을 보내고 응답받음
        MbtiResponseDto response = webClientBuilder.build()
                .post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(MbtiResponseDto.class)
                .block();  // block() 메소드를 사용하여 결과를 받아옴. 주의: block()은 비동기 작업을 동기 작업으로 만들어버리므로 적절히 사용해야 함.

        //응답받은 데이터를 MBTI객체로 저장
        User user = userRepository.findById(requestDto.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + requestDto.getUser_id()));
        Mbti mbti = mbtiRepository.save(requestDto.toEntity(user));
        return MbtiResponseDto.fromEntity(mbti);
    }

    @Override
    @Transactional(readOnly = true)
    public MbtiResponseDto getMbti(Long userId) {
        Mbti mbti = mbtiRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
        return MbtiResponseDto.fromEntity(mbti);
    }
}
