package com.mbtiai.demo.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor //비권장이지만 없으면 오류
@Table(name = "user")
public class User   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long user_id;

    @Column
    private float e_per;

    @Column
    private float i_per;

    @Column
    private float n_per;

    @Column
    private float s_per;

    @Column
    private float t_per;

    @Column
    private float f_per;

    @Column
    private float p_per;

    @Column
    private float j_per;

    @Builder
    public User(float e_per, float i_per, float n_per, float s_per, float t_per, float f_per, float p_per, float j_per){
        this.e_per = e_per;
        this.i_per = i_per;
        this.n_per = n_per;
        this.s_per = s_per;
        this.t_per = t_per;
        this.f_per = f_per;
        this.p_per = p_per;
        this.j_per = j_per;

    }

}
