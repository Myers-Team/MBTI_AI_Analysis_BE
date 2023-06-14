package com.mbtiai.demo.qa;

import com.mbtiai.demo.mbti.Mbti;
import com.mbtiai.demo.user.User;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QaRequestDto {

    private String question;
    private String answer;
    private float emd_v;
    private Long user_id;

    public Qa toEntity(User user) {
        return Qa.builder()
                .question(question)
                .answer(answer)
                .emd_v(emd_v)
                .user(user)
                .build();
    }
}
