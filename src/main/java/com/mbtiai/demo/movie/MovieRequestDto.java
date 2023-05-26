package com.mbtiai.demo.movie;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieRequestDto {
    @NotBlank(message = "영화 제목을 입력하세요.")
    private String movie_name;

    public Movie toEntity(){
        return Movie.builder()
                .movie_name(movie_name)
                .build();
    }

}
