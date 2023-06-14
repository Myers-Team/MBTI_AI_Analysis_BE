package com.mbtiai.demo.mbti;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MbtiResponseDto {
    private float e_per;
    private float i_per;
    private float n_per;
    private float s_per;
    private float t_per;
    private float f_per;
    private float p_per;
    private float j_per;
    private Long user_id;  // User ID도 함께 반환해야 합니다

    public static MbtiResponseDto fromEntity(Mbti mbti) {
        return MbtiResponseDto.builder()
                .e_per(mbti.getE_per())
                .i_per(mbti.getI_per())
                .n_per(mbti.getN_per())
                .s_per(mbti.getS_per())
                .t_per(mbti.getT_per())
                .f_per(mbti.getF_per())
                .p_per(mbti.getP_per())
                .j_per(mbti.getJ_per())
                .user_id(mbti.getUser().getUser_id())
                .build();
    }
}



