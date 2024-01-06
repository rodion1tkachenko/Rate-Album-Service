package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.o0000q.ratealbumservice.entity.UsersRating;
import ru.o0000q.ratealbumservice.repository.UserRatingRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersRatingService {
    private final UserRatingRepository userRatingRepository;

    public void saveUsersRating(UsersRating usersRating) {
        userRatingRepository.saveUsersRating(usersRating);
    }

}
