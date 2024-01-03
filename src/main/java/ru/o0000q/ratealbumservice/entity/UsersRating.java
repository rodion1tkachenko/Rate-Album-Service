package ru.o0000q.ratealbumservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    private Integer rate;

    public void setUser(User user) {
        this.user = user;
        user.getUsersRatings().add(this);
    }

    public void setAlbum(Album album) {
        this.album = album;
        album.getUsersRatings().add(this);
    }
}
