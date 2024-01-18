package ru.o0000q.ratealbumservice.mapper;

import org.springframework.stereotype.Component;
import ru.o0000q.ratealbumservice.dto.AlbumDto;
import ru.o0000q.ratealbumservice.entity.Album;
@Component
public class AlbumMapper implements Mapper<Album, AlbumDto> {
    @Override
    public AlbumDto fromEntityToDto(Album object) {
        return AlbumDto.builder()
                .id(object.getId())
                .title(object.getTitle())
                .cover(object.getCover())
                .genre(object.getGenre())
                .singer(object.getSinger())
                .usersRatings(object.getUsersRatings())
                .build();
    }

    @Override
    public Album fromDtoToEntity(AlbumDto object) {
        return Album.builder()
                .id(object.getId())
                .title(object.getTitle())
                .cover(object.getCover())
                .genre(object.getGenre())
                .singer(object.getSinger())
                .usersRatings(object.getUsersRatings())
                .build();
    }
}
