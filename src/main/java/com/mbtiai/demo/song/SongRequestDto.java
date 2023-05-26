package com.mbtiai.demo.song;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SongRequestDto {
    @NotBlank(message = "노래 제목을 입력하세요.")
    private String song_name;

    public Song toEntity(){
        return Song.builder()
                .song_name(song_name)
                .build();
    }
}
