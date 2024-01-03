package ru.o0000q.ratealbumservice.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.o0000q.ratealbumservice.entity.enums.Role;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@EqualsAndHashCode(exclude = "usersRatings")
@ToString(exclude = "usersRatings")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String nickname;
    private Role role;
    @OneToMany(mappedBy = "user")
//    @Builder.Default
    private List<UsersRating>usersRatings;
}



