package ru.o0000q.ratealbumservice.integration.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.o0000q.ratealbumservice.dto.UserDto;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.entity.enums.Role;
import ru.o0000q.ratealbumservice.mapper.UserMapperImp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserMapperIT {
    @Autowired
    private UserMapperImp userMapper;
    private static final UserDto USER_VASYA_DTO = UserDto.builder()
            .id(2L)
            .login("vasyan123")
            .password("pass")
            .role(Role.USER)
            .nickname("vasyagog")
            .build();
    private static final User USER_VASYA = User.builder()
            .id(2L)
            .login("vasyan123")
            .password("pass")
            .role(Role.USER)
            .nickname("vasyagog")
            .build();

    @Test
    void successCheckMapperFromDtoToEntity(){
        assertThat(userMapper.fromUserDtoToUser(USER_VASYA_DTO))
                .isEqualTo(USER_VASYA);
    }
    @Test
    void successCheckMapperFromEntityToDto(){
        assertThat(userMapper.fromUserToUserDto(USER_VASYA))
                .isEqualTo(USER_VASYA_DTO);
    }
    @Test
    void mappingFromDtoToEntityThrowsExceptionWithArgumentNull(){
        org.junit.jupiter.api.Assertions.assertThrows(
                NullPointerException.class,
                ()-> userMapper.fromUserDtoToUser(null));
    }
    @Test
    void mappingFromDEntityToDtoThrowsExceptionWithArgumentNull(){
        org.junit.jupiter.api.Assertions.assertThrows(
                NullPointerException.class,
                ()-> userMapper.fromUserToUserDto(null));
    }
}
