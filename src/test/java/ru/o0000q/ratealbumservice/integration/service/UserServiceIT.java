package ru.o0000q.ratealbumservice.integration.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.o0000q.ratealbumservice.dto.UserDto;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.entity.enums.Role;
import ru.o0000q.ratealbumservice.integration.IntegrationTestBase;
import ru.o0000q.ratealbumservice.mapper.UserMapperImp;
import ru.o0000q.ratealbumservice.service.UserService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceIT extends IntegrationTestBase {
    private static final User USER_FROM_DATABASE = User.builder()
            .id(1L)
            .login("user1")
            .password("password1")
            .nickname("nickname1")
            .role(Role.USER)
            .build();
    private static final User USER_VASYA = User.builder()
            .login("vasya123")
            .nickname("Vasilly")
            .password("123")
            .role(Role.USER)
            .build();
    private static final User USER_WITH_EXIST_ID = User.builder()
            .id(1L)
            .login("vasya321")
            .nickname("Vasilly2")
            .password("123")
            .role(Role.USER)
            .build();
    @Autowired
    private UserService userService;

    @Test
    void methodShouldSaveUser() {
        userService.saveUser(USER_VASYA);
        Optional<User> maybeUser = userService.getUserByNickname(USER_VASYA.getNickname());
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(
                user -> assertEquals(user, USER_VASYA)
        );
    }

    @Test
    void methodSaveShouldThrowNpeWithNullArgument() {
        assertThrows(NullPointerException.class,
                () -> userService.saveUser(null));

    }

    @Test
    void methodShouldSaveUserWithExistingId() {
        userService.saveUser(USER_WITH_EXIST_ID);
        Optional<User> maybeUserAfterSave = userService.getUserById(1L);
        assertTrue(maybeUserAfterSave.isPresent());
        maybeUserAfterSave.ifPresent(userFromDB -> {
            assertAll(
                    () -> assertEquals(USER_WITH_EXIST_ID, userFromDB)

            );
        });
    }

    @Test
    void getUserByIdShouldReturnAccurateUser() {
        Optional<User> actualResult = userService.getUserById(1L);
        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user ->
                assertAll(
                        () -> assertEquals(USER_FROM_DATABASE.getId(), user.getId()),
                        () -> assertEquals(USER_FROM_DATABASE.getRole(), user.getRole()),
                        () -> assertEquals(USER_FROM_DATABASE.getNickname(), user.getNickname()),
                        () -> assertEquals(USER_FROM_DATABASE.getPassword(), user.getPassword()),
                        () -> assertEquals(USER_FROM_DATABASE.getLogin(), user.getLogin())
                ));
    }

    @Test
    void twoGetUserByIdInvokeShouldReturnDifferentUsers() {
        Optional<User> user1 = userService.getUserById(1L);
        Optional<User> user2 = userService.getUserById(2L);
        assertNotEquals(user1, user2);
    }

    @Test
    void getUserByIdShouldReturnEmptyOptionalIfUserIdIsNotInDatabase() {
        Optional<User> maybeUser = userService.getUserById(3L);
        assertFalse(maybeUser.isPresent());
    }

    @Test
    void deleteByIdShouldDeleteUserWithIdOne() {
        userService.deleteById(1L);
        Optional<User> userById = userService.getUserById(1L);
        assertFalse(userById.isPresent());
    }

    @Test
    void deleteByIdShouldNotDeleteAnyUserBecauseArgumentIdIsNotInDatabase() {
        userService.deleteById(3L);
        assertEquals(userService.findAll()
                .size(), 2);
    }

    @Test
    void findAllShouldReturnTwoUsers() {
        assertThat(userService.findAll().size()).isEqualTo(2);
    }

    @Test
    void findAllShouldHasCorrectUser() {
        assertTrue(userService.findAll().contains(USER_FROM_DATABASE));
    }


}
