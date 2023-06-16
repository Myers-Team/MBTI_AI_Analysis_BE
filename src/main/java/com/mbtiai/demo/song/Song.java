package com.mbtiai.demo.song;

import com.mbtiai.demo.contents.Contents;
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


    @Column
    private int likeCount = 0;

    @Column
    private int dislikeCount = 0;

    @ManyToOne
    @JoinColumn(name = "contents_id")
    private Contents contents;


    @Builder
    public Song(String song_name, int s_like, int s_hate, Contents contents) {
        this.song_name = song_name;
        this.s_like = s_like;
        this.s_hate = s_hate;
        this.contents = contents;
    }

    public void incrementLikeCount() {
        this.likeCount++;
    }

    public void incrementDislikeCount() {
        this.dislikeCount++;
    }

}
