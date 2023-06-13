package com.mbtiai.demo.pmbti;

import com.mbtiai.demo.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor //비권장이지만 없으면 오류
@Table(name = "pmbti")
public class Pmbti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pmbti_id", unique = true, nullable = false)
    private Long pmbti_id;

    @Column
    private float p_e_per;

    @Column
    private float p_i_per;

    @Column
    private float p_n_per;

    @Column
    private float p_s_per;

    @Column
    private float p_t_per;

    @Column
    private float p_f_per;

    @Column
    private float p_p_per;

    @Column
    private float p_j_per;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Builder
    public Pmbti(float p_e_per, float p_i_per, float p_n_per, float p_s_per, float p_t_per, float p_f_per, float p_p_per, float p_j_per, User user){
        this.p_e_per = p_e_per;
        this.p_i_per = p_i_per;
        this.p_n_per = p_n_per;
        this.p_s_per = p_s_per;
        this.p_t_per = p_t_per;
        this.p_f_per = p_f_per;
        this.p_p_per = p_p_per;
        this.p_j_per = p_j_per;
        this.user = user;


    }
}
