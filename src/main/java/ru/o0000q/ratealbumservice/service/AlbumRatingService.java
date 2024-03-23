package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.o0000q.ratealbumservice.dto.AlbumRatingDto;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.AlbumRating;
import ru.o0000q.ratealbumservice.entity.UsersRating;
import ru.o0000q.ratealbumservice.mapper.AlbumRatingMapper;
import ru.o0000q.ratealbumservice.repository.AlbumRatingRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
        return albumRatingMapper.fromEntityToDto(albumRatingRepository.findBestAlbum());
    }

    public void addRate(UsersRating usersRating) {
        //TODO:add logic
//        Long id = usersRating.getAlbum().getId();
        AlbumRating albumRatingByAlbum = albumRatingRepository.findAlbumRatingByAlbum(usersRating.getAlbum());
        albumRatingRepository.addRate(albumRatingByAlbum.getId(),
                usersRating.getRate(),
                albumRatingByAlbum.getAverageRating(),
                albumRatingByAlbum.getNumberOfRatings());

    }
}
