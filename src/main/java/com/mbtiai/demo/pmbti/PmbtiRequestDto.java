package com.mbtiai.demo.pmbti;

import com.mbtiai.demo.user.User;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PmbtiRequestDto {

    private float p_e_per;
    private float p_i_per;
    private float p_n_per;
    private float p_s_per;
    private float p_t_per;
    private float p_f_per;
    private float p_p_per;
    private float p_j_per;
    private Long user_id; // User의 ID를 받아오는 경우

    public Pmbti toEntity(User user){
        return Pmbti.builder()
                .p_e_per(p_e_per)
                .p_i_per(p_i_per)
                .p_n_per(p_n_per)
                .p_s_per(p_s_per)
                .p_t_per(p_t_per)
                .p_f_per(p_f_per)
                .p_p_per(p_p_per)
                .p_j_per(p_j_per)
                .user(user)
                .build();
    }
}
