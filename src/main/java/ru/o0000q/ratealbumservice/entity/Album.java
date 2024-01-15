package ru.o0000q.ratealbumservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"singer", "usersRatings"})
@ToString(exclude = {"singer", "usersRatings"})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private byte[] cover;
    private String genre;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @Builder.Default
    private Singer singer;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
//    @Builder.Default
    private List<UsersRating>usersRatings=new ArrayList<>();

    public void setSinger(Singer singer) {
        this.singer = singer;
        singer.getAlbums().add(this);
    }
}
