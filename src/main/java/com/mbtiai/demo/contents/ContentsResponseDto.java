package com.mbtiai.demo.contents;


import com.mbtiai.demo.movie.MovieResponseDto;
import com.mbtiai.demo.song.SongResponseDto;
import lombok.Builder;
import lombok.Getter;

//ResponseDto는 정보를 반환해 주는 것
@Builder
@Getter
public class ContentsResponseDto {
    private MovieResponseDto movie;
    private SongResponseDto song;

    public ContentsResponseDto(MovieResponseDto movie, SongResponseDto song) {
        this.movie = movie;
        this.song = song;
    }
}
