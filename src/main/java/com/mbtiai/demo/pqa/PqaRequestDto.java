package com.mbtiai.demo.pqa;

import com.mbtiai.demo.qa.Qa;
import com.mbtiai.demo.user.User;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PqaRequestDto {
    private String p_question;
    private String p_answer;
    private float p_emd_v;
    private Long user_id;

    public Pqa toEntity(User user) {
        return Pqa.builder()
                .p_question(p_question)
                .p_answer(p_answer)
                .p_emd_v(p_emd_v)
                .user(user)
                .build();
    }
}
