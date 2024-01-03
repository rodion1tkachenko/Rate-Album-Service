package ru.o0000q.ratealbumservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.Singer;
import ru.o0000q.ratealbumservice.repository.AlbumRepository;
import ru.o0000q.ratealbumservice.repository.SingerRepository;

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
//        var albumRepository=context.getBean(AlbumRepository.class);
//        var singerRepository=context.getBean(SingerRepository.class);
//        var albumService=context.getBean(AlbumService.class);
//        Singer singer =singerRepository.getSingerByName("Young Thug");
//        Album album = Album.builder()
//                .title("Slime World 2")
//                .genre("Hip-Hop")
//                .build();
//        album.setSinger(singer);
//        albumService.saveAlbum(album);
//        singerRepository.saveSinger(singer);
    }

}
