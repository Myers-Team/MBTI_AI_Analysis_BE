package com.mbtiai.demo.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor //비권장이지만 없으면 오류
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", unique = true, nullable = false)
    private Long movie_id;

    @Column
    private String movie_name;

    @Column
    private int m_like;

    @Column
    private int m_hate;

}
