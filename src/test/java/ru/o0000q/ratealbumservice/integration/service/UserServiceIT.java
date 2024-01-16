package ru.o0000q.ratealbumservice.integration.service;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.fuctests.Customer;
import ru.o0000q.ratealbumservice.fuctests.CustomerRepository;
import ru.o0000q.ratealbumservice.integration.IntegrationTestBase;
import ru.o0000q.ratealbumservice.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceIT extends IntegrationTestBase {
    @Autowired
    private UserService userService;

//    @LocalServerPort
//    private Integer port;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:latest"
    );

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void serviceShouldSaveUser() {
        userService.saveUser(User.builder()
                        .login("vasya123")
                        .nickname("vasre")
                        .password("123")
                .build());
        User user = userService.getUserByNickname("vasre");
        assertAll(
                ()->assertEquals(user.getNickname(),"vasre"),
                ()->assertEquals(user.getPassword(),"123")

        );
    }

}
