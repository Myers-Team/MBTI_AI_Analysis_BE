package com.mbtiai.demo.contents;


import com.mbtiai.demo.movie.MovieResponseDto;
import com.mbtiai.demo.movie.MovieService;
import com.mbtiai.demo.song.SongResponseDto;
import com.mbtiai.demo.song.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contents")
public class ContentsController {

    private final MovieService movieService;
    private final SongService songService;

    public ContentsController(MovieService movieService, SongService songService) {
        this.movieService = movieService;
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<ContentsResponseDto> getContents() {
        MovieResponseDto recommendedMovie = movieService.recommendMovie();
        SongResponseDto recommendedSong = songService.recommendSong();
        ContentsResponseDto contents = new ContentsResponseDto(recommendedMovie, recommendedSong);
        return ResponseEntity.ok(contents);
    }

    @PostMapping("/movies/{id}/like")
    public ResponseEntity<Void> likeMovie(@PathVariable Long id) {
        movieService.likeMovie(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/movies/{id}/dislike")
    public ResponseEntity<Void> dislikeMovie(@PathVariable Long id) {
        movieService.dislikeMovie(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/songs/{id}/like")
    public ResponseEntity<Void> likeSong(@PathVariable Long id) {
        songService.likeSong(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/songs/{id}/dislike")
    public ResponseEntity<Void> dislikeSong(@PathVariable Long id) {
        songService.dislikeSong(id);
        return ResponseEntity.ok().build();
    }
}
