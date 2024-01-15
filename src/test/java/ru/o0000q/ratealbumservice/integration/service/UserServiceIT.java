package ru.o0000q.ratealbumservice.integration.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.integration.IntegrationTestBase;
import ru.o0000q.ratealbumservice.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceIT extends IntegrationTestBase {
    @Autowired
    private UserService userService;
    @Test
    void containerIsUp(){


        System.out.println();
    }
}
