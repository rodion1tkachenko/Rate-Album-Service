package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.o0000q.ratealbumservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    default void saveUser(User user){
        save(user);
    }
}
