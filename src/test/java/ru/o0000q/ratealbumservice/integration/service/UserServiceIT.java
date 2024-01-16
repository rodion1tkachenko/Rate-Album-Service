package ru.o0000q.ratealbumservice.integration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.entity.enums.Role;
import ru.o0000q.ratealbumservice.integration.IntegrationTestBase;
import ru.o0000q.ratealbumservice.service.UserService;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceIT extends IntegrationTestBase {
    private static User USER_VASYA = User.builder()
            .login("vasya123")
            .nickname("vasre")
            .password("123")
            .role(Role.USER)
            .build();
    @Autowired
    private UserService userService;

    @Test
    void methodShouldSaveUser() {
        userService.saveUser(USER_VASYA);
        User user = userService.getUserByNickname("vasre");
        assertAll(
                () -> assertEquals(user.getNickname(), "vasre"),
                () -> assertEquals(user.getPassword(), "123")

        );
    }

}
