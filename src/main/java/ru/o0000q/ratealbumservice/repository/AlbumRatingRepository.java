package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.AlbumRating;

@Repository
public interface AlbumRatingRepository extends JpaRepository<AlbumRating, Long> {

    @Query("""
                select ar from AlbumRating as ar
                order by ar.averageRating
                limit 1
            """)
    AlbumRating findBestAlbum();

    @Modifying
    @Query("""
                    update AlbumRating as ar
                    set ar.averageRating=(?3*?4 + ?2)/(?4+1),
                    ar.numberOfRatings = ar.numberOfRatings+1
                    where ar.id=?1
            """)
    void addRate(Long id,
            Integer rate,
            Double avgRate,
            Integer amountOfRate);
    AlbumRating findAlbumRatingByAlbum(Album album);
}
