package ru.o0000q.ratealbumservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.Singer;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.entity.UsersRating;
import ru.o0000q.ratealbumservice.repository.AlbumRepository;
import ru.o0000q.ratealbumservice.repository.SingerRepository;
import ru.o0000q.ratealbumservice.repository.UserRepository;
import ru.o0000q.ratealbumservice.service.AlbumService;
import ru.o0000q.ratealbumservice.service.UserService;
import ru.o0000q.ratealbumservice.service.UsersRatingService;

import java.util.Optional;

@SpringBootApplication
public class RateAlbumServiceApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(RateAlbumServiceApplication.class, args);
        UserService userService = context.getBean(UserService.class);
        userService.saveUser(User.builder()
                        .login("123")
                        .nickname("123")
                        .password("123")
                .build());
    }

}
