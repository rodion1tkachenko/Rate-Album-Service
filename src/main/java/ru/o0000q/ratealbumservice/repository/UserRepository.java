package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.entity.enums.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    default void saveUser(User user){
        save(user);
    }
    Optional<User>getUserById(Long id);
    Optional<User> getUserByNickname(String nickname);
    Optional<User> getUserByLogin(String nickname);
    List<User> getUsersByRole(Role role);
    @Modifying
    @Query("update User u " +
            "set u.password =?1, u.login=?2,u.nickname=?3 where u.id=?4")
    void setUserInfo(String password,String login,String nickname, Long id);

    void deleteById(Long id);

}
