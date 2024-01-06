package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.Singer;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    default void saveAlbum(Album album) {
        save(album);
    }
    Optional<Album> getAlbumById(Long id);
    Optional<Album> getAlbumByTitle(String string);
    List<Album> findAllBySinger(Singer singer);
    Optional<Album>getAlbumByTitleAndSingerName(String title,String singerName);

    @Modifying
    @Query("update Album a "+
            "set a.title = ?1 where a.id = ?2")
    void setAlbumTitle(String title, Long id);

    @Modifying
    @Query("update Album a "+
            "set a.cover = ?1 where a.id = ?2")
    void setAlbumCover(byte[] cover, Long id);
    @Modifying
    @Query("update Album a "+
            "set a.singer = ?1 where a.id = ?2")
    void setAlbumCover(Singer singer, Long id);

    boolean deleteAlbumById(Long id);
    boolean deleteAlbumByTitle(String title);
    int countAll();

}
