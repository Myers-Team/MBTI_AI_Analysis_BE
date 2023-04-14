package com.mbtiai.demo.song;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor //비권장이지만 없으면 오류
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id", unique = true, nullable = false)
    private Long song_id;

    @Column
    private String song_name;

    @Column
    private int s_like;

    @Column
    private int s_hate;

}
