package com.mbtiai.demo.movie;

public interface MovieService {
    MovieResponseDto recommendMovie();
    void likeMovie(Long id);
    void dislikeMovie(Long id);

}
