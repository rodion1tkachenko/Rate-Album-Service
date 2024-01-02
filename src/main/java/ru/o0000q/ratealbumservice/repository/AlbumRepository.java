package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.o0000q.ratealbumservice.entity.Album;

public interface AlbumRepository extends JpaRepository<Album,Long> {
    default void  saveAlbum(Album album){
        save(album);
    }
}
