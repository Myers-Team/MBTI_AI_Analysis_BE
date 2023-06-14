package com.mbtiai.demo.qa;

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
@Table(name = "qa")
public class Qa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qa_id", unique = true, nullable = false)
    private Long qa_id;

    @Column
    private String question;

    @Column
    private String answer;

    @Column
    private float emd_v;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Qa(String answer, String question, User user){
        this.answer = answer;
        this.question = question;
        this.user = user;
    }

}