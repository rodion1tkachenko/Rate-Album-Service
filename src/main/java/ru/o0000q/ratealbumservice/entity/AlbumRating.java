package ru.o0000q.ratealbumservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "album_rating")
public class AlbumRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    @Column(name = "number_of_ratings")
    private Integer numberOfRatings;
    @Column(name = "average_rating")
    private Double averageRating;
}
