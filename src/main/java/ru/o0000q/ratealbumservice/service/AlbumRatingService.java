package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.AlbumRating;
import ru.o0000q.ratealbumservice.repository.AlbumRatingRepository;

@Service
@RequiredArgsConstructor
public class AlbumRatingService {
    private final AlbumRatingRepository albumRatingRepository;
    public AlbumRating save(Album album) {
        return albumRatingRepository.save
                (AlbumRating.builder()
                        .album(album)
                        .build());
    }
}
