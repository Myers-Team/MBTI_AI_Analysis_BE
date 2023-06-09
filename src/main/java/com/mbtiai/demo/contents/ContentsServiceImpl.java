package com.mbtiai.demo.contents;

import com.mbtiai.demo.movie.MovieRepository;
import com.mbtiai.demo.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service
public class ContentsServiceImpl implements ContentsService{
    private final ContentsRepository contentsRepository;
    private final MovieRepository movieRepository;
    private final SongRepository songRepository;

    public ContentsServiceImpl(ContentsRepository contentsRepository, MovieRepository movieRepository, SongRepository songRepository) {
        this.contentsRepository = contentsRepository;
        this.movieRepository = movieRepository;
        this.songRepository = songRepository;
    }

    /*
    @Transactional(readOnly = true)
    public ContentsResponseDto getRecommendedContent() {
        // 첫 번째 Movie와 Song을 가져옵니다.
        Movie movie = movieRepository.findAll().get(0);
        Song song = songRepository.findAll().get(0);

        // Movie와 Song을 포함하는 ContentsResponseDto를 반환합니다.
        return ContentsResponseDto.builder()
                .tot_con(movie.getContents().getTot_con())
                .movie(MovieResponseDto.fromEntity(movie))
                .song(SongResponseDto.fromEntity(song))
                .build();
    }
    */
}
