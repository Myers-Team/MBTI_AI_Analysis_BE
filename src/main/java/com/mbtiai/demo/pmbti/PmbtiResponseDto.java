package com.mbtiai.demo.pmbti;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PmbtiResponseDto {

    private float p_e_per;
    private float p_i_per;
    private float p_n_per;
    private float p_s_per;
    private float p_t_per;
    private float p_f_per;
    private float p_p_per;
    private float p_j_per;
    private Long user_id; // User의 ID를 반환하는 경우

    public static PmbtiResponseDto fromEntity(Pmbti pmbti){
        return PmbtiResponseDto.builder()
                .p_e_per(pmbti.getP_e_per())
                .p_i_per(pmbti.getP_i_per())
                .p_n_per(pmbti.getP_n_per())
                .p_s_per(pmbti.getP_s_per())
                .p_t_per(pmbti.getP_t_per())
                .p_f_per(pmbti.getP_f_per())
                .p_p_per(pmbti.getP_p_per())
                .p_j_per(pmbti.getP_j_per())
                .user_id(pmbti.getUser().getUser_id())
                .build();
    }
}