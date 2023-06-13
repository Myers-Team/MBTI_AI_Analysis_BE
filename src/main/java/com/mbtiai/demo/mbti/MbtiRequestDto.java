package com.mbtiai.demo.mbti;

import com.mbtiai.demo.user.User;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MbtiRequestDto {
    private float e_per;
    private float i_per;
    private float n_per;
    private float s_per;
    private float t_per;
    private float f_per;
    private float p_per;
    private float j_per;
    private Long user_id;  // User ID도 함께 받아야 합니다

    public Mbti toEntity(User user) {
        return Mbti.builder()
                .e_per(e_per)
                .i_per(i_per)
                .n_per(n_per)
                .s_per(s_per)
                .t_per(t_per)
                .f_per(f_per)
                .p_per(p_per)
                .j_per(j_per)
                .user(user)
                .build();
    }
}
