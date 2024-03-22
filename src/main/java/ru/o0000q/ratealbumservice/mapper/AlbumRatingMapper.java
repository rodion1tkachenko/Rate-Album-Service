package ru.o0000q.ratealbumservice.mapper;

import org.springframework.stereotype.Component;
import ru.o0000q.ratealbumservice.dto.AlbumRatingDto;
import ru.o0000q.ratealbumservice.entity.AlbumRating;
@Component
public class AlbumRatingMapper implements Mapper<AlbumRating, AlbumRatingDto> {
    @Override
    public AlbumRatingDto fromEntityToDto(AlbumRating object) {
        return AlbumRatingDto.builder()
                .albumId(object.getId())
                .numberOfRatings(object.getNumberOfRatings())
                .albumName(object.getAlbum().getTitle())
                .averageRating(object.getAverageRating())
                .build();
    }

    @Override
    public AlbumRating fromDtoToEntity(AlbumRatingDto object) {
        return null;
    }
}
