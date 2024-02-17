package ru.o0000q.ratealbumservice.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import ru.o0000q.ratealbumservice.entity.UsersRating;
import ru.o0000q.ratealbumservice.entity.enums.Role;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private String nickname;
    private Role role;

}
