package com.mbtiai.demo.movie;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MovieResponseDto {
    private String movie_name;
    private int m_like;
    private int m_hate;
    private int likeCount;
    private int dislikeCount;

    public static MovieResponseDto fromEntity(Movie movie) {
        return MovieResponseDto.builder()
                .movie_name(movie.getMovie_name())
                .m_like(movie.getM_like())
                .m_hate(movie.getM_hate())
                .likeCount(movie.getLikeCount())
                .dislikeCount(movie.getDislikeCount())
                .build();
    }
}
