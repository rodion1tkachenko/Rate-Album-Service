package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.o0000q.ratealbumservice.dto.AlbumRatingDto;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.UsersRating;
import ru.o0000q.ratealbumservice.repository.UserRatingRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersRatingService {
    private final UserRatingRepository userRatingRepository;


    public List<Album> getAllRatedAlbumsByUserId(Long id) {
        return userRatingRepository.getDistinctUserId(id);
    }

    public void saveUsersRating(UsersRating usersRating) {
        userRatingRepository.saveUsersRating(usersRating);
    }

    public Optional<UsersRating> getUsersRatingById(Long id) {
        return userRatingRepository.getUsersRatingById(id);
    }

//    public List<AlbumRatingDto> getBestAlbums() {
//        return userRatingRepository.getBestAlbum();
//    }
}
