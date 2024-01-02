package ru.o0000q.ratealbumservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private byte[] cover;
    private String genre;
    @ManyToOne
    private Singer singer;

    public void setSinger(Singer singer) {
        this.singer = singer;
        singer.getAlbums().add(this);
    }
}
