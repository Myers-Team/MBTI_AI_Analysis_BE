package com.mbtiai.demo.song;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SongResponseDto {
    private String song_name;
    private int s_like;
    private int s_hate;
    private int likeCount;
    private int dislikeCount;

    public static SongResponseDto fromEntity(Song song) {
        return SongResponseDto.builder()
                .song_name(song.getSong_name())
                .s_like(song.getS_like())
                .s_hate(song.getS_hate())
                .likeCount(song.getLikeCount())
                .dislikeCount(song.getDislikeCount())
                .build();
    }
}
