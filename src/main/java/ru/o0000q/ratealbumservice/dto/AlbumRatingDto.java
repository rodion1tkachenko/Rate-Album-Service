package ru.o0000q.ratealbumservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbumRatingDto {
    private Long albumId;
    private String albumName;
    private Integer numberOfRatings;

    private Double averageRating;
}
