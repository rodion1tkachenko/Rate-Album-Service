package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.o0000q.ratealbumservice.dto.AlbumRatingDto;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.AlbumRating;
import ru.o0000q.ratealbumservice.mapper.AlbumRatingMapper;
import ru.o0000q.ratealbumservice.repository.AlbumRatingRepository;

@Service
@RequiredArgsConstructor
public class AlbumRatingService {
    private final AlbumRatingRepository albumRatingRepository;
    private final AlbumRatingMapper albumRatingMapper;
    public AlbumRating save(Album album) {
        return albumRatingRepository.save
                (AlbumRating.builder()
                        .album(album)
                        .build());
    }

    public AlbumRatingDto getBestAlbum() {
        return  albumRatingMapper.fromEntityToDto(albumRatingRepository.findBestAlbum());
    }
}
