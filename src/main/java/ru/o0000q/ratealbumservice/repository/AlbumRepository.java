package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.o0000q.ratealbumservice.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    default void saveAlbum(Album album) {
        save(album);
    }
}
