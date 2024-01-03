package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.o0000q.ratealbumservice.entity.UsersRating;
@Repository
public interface UserRatingRepository extends JpaRepository<UsersRating,Long> {
    default void saveUsersRating(UsersRating usersRating){
        save(usersRating);
    }
}
