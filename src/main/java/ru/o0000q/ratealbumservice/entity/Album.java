package ru.o0000q.ratealbumservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "singer")
@ToString(exclude = "singer")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private byte[] cover;
    private String genre;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Singer singer;

    public void setSinger(Singer singer) {
        this.singer = singer;
        singer.getAlbums().add(this);
    }
}
