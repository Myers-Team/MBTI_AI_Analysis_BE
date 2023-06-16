package com.mbtiai.demo.song;

public interface SongService {
    SongResponseDto recommendSong();
    void likeSong(Long id);
    void dislikeSong(Long id);

}
