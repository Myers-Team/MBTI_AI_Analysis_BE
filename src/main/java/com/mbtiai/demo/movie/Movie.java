package com.mbtiai.demo.movie;

import com.mbtiai.demo.contents.Contents;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @ManyToOne
    @JoinColumn(name = "contents_id")
    private Contents contents;

    @Builder
    public Movie(String movie_name, int m_like, int m_hate, Contents contents) {
        this.movie_name = movie_name;
        this.m_like = m_like;
        this.m_hate = m_hate;
        this.contents = contents;
    }
}
