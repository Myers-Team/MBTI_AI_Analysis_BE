package com.mbtiai.demo.contents;

import com.mbtiai.demo.movie.Movie;
import com.mbtiai.demo.song.Song;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor //비권장이지만 없으면 오류
@Table(name = "contents")
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contents_id", unique = true, nullable = false)
    private Long contents_id;

    @Column
    private String tot_con;

    @Builder
    public Contents(String tot_con) {
        this.tot_con=tot_con;
    }
}
