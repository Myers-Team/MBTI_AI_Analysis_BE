package com.mbtiai.demo.pqa;

import com.mbtiai.demo.contents.Contents;
import com.mbtiai.demo.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor //비권장이지만 없으면 오류
@Table(name = "pqa")
public class Pqa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pqa_id", unique = true, nullable = false)
    private Long pqa_id;

    @Column
    private String p_question;

    @Column
    private String p_answer;

    @Column
    private float p_emd_v;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Pqa(String p_answer, String p_question, User user){
        this.p_answer = p_answer;
        this.p_question = p_question;
        this.user = user;
    }

}