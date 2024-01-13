package ru.o0000q.ratealbumservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.o0000q.ratealbumservice.dto.UserDto;
import ru.o0000q.ratealbumservice.entity.User;
@Mapper
public interface UserMapper  {


     UserDto fromUserToUserDto(User user);
     User fromUserDtoToUser(UserDto userDto);



}
