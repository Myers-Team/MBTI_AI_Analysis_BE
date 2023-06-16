package com.mbtiai.demo.song;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;


    public SongResponseDto recommendSong() {
        // 이 메소드에서 노래를 추천하는 로직을 작성해야함
        // 아래는 그냥 첫 번째 노래를 반환하는 예시
        Song song = songRepository.findAll().get(0);
        return SongResponseDto.fromEntity(song);
    }

    public void likeSong(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No song found with id: " + id));
        song.incrementLikeCount();
        songRepository.save(song);
    }

    public void dislikeSong(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No song found with id: " + id));
        song.incrementDislikeCount();
        songRepository.save(song);
    }
}
