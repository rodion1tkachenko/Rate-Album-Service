package ru.o0000q.ratealbumservice.mapper;

import org.springframework.stereotype.Component;
import ru.o0000q.ratealbumservice.dto.UserDto;
import ru.o0000q.ratealbumservice.entity.User;
@Component
public class UserMapperImp implements UserMapper{
    @Override
    public UserDto fromUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    @Override
    public User fromUserDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .nickname(userDto.getNickname())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();
    }
}
