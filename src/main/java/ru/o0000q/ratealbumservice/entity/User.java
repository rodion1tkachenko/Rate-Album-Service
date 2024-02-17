package ru.o0000q.ratealbumservice.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.o0000q.ratealbumservice.entity.enums.Role;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users", schema = "public")
@EqualsAndHashCode(exclude = "usersRatings")
@ToString(exclude = "usersRatings")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Builder.Default
    private List<UsersRating>usersRatings=new ArrayList<>();
}



