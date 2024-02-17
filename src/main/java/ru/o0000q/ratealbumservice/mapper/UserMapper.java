package ru.o0000q.ratealbumservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.o0000q.ratealbumservice.dto.UserDto;
import ru.o0000q.ratealbumservice.entity.User;
public interface UserMapper  {


     UserDto fromUserToUserDto(User user);
     User fromUserDtoToUser(UserDto userDto);



}
