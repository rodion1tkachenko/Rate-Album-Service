package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.entity.UsersRating;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRatingRepository extends JpaRepository<UsersRating,Long> {
    default void saveUsersRating(UsersRating usersRating){
        save(usersRating);
    }
    Optional<UsersRating>getUsersRatingById(Long id);
    Optional<UsersRating>getUsersRatingByUser(User user);
    Optional<UsersRating>getUsersRatingsByAlbum(Album album);
    Optional<UsersRating>getUsersRatingByUserAndAlbum(User user,Album album);
    @Modifying
    @Query("update UsersRating u " +
            "set u.rate=?1 where u.id=?2")
    void setUserRating(Integer rating,Long id);
    void deleteById(Long id);
    @Modifying
    @Query("select distinct ur.album from UsersRating as ur " +
            "join ur.user as u" +
            " where u.id =?1")
    List<Album>getDistinctUserId(Long id);

}
