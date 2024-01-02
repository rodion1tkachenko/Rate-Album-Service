package ru.o0000q.ratealbumservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.Singer;
import ru.o0000q.ratealbumservice.repository.AlbumRepository;

@SpringBootApplication
public class RateAlbumServiceApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(RateAlbumServiceApplication.class, args);
//        UserRepository repository = context.getBean(UserRepository.class);
//        repository.saveUser(User.builder()
//                        .login("vasya")
//                        .password("123")
//                        .nickname("vasya123")
//                .build());
        var albumRepository=context.getBean(AlbumRepository.class);
        Singer singer = Singer.builder()
                .name("Young Thug")
                .build();
        Album album = Album.builder()
                .title("So much fun")
                .genre("Hip-Hop")
                .build();
        album.setSinger(singer);
        albumRepository.saveAlbum(album);
    }

}
