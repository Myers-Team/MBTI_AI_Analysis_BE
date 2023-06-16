package com.mbtiai.demo.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    public MovieResponseDto recommendMovie() {
        // 이 메소드에서 영화를 추천하는 로직을 작성해야함
        // 아래는 그냥 첫 번째 영화를 반환하는 예시
        Movie movie = movieRepository.findAll().get(0);
        return MovieResponseDto.fromEntity(movie);
    }

    public void likeMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No movie found with id: " + id));
        movie.incrementLikeCount();
        movieRepository.save(movie);
    }

    public void dislikeMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No movie found with id: " + id));
        movie.incrementDislikeCount();
        movieRepository.save(movie);
    }
}
