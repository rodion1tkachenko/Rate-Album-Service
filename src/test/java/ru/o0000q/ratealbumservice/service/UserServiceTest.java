package ru.o0000q.ratealbumservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.o0000q.ratealbumservice.dto.UserDto;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.entity.enums.Role;
import ru.o0000q.ratealbumservice.mapper.Mapper;
import ru.o0000q.ratealbumservice.mapper.UserMapper;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;
//    @MockBean
//    private UserMapper userMapper;
    private static final UserDto USER_VASYA = UserDto.builder()
            .id(2L)
            .login("vasyan123")
            .password("pass")
            .role(Role.USER)
            .nickname("vasyagog")
            .build();

    @Test
    void checkMapper() {

    }

}