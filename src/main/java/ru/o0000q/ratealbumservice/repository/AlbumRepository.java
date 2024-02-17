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
            "set a.title = ?1, a.genre=?2,a.cover=?3 where a.id = ?4")
    void setAlbumInfo(String title,
                      String genre,
                      byte[] bytes,
                      Long id);



    Integer deleteAlbumById(Long id);
    boolean deleteAlbumByTitle(String title);
//    int countAll();

}
