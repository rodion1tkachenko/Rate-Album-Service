package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.o0000q.ratealbumservice.entity.AlbumRating;

@Repository
public interface AlbumRatingRepository extends JpaRepository<AlbumRating,Long> {

}
