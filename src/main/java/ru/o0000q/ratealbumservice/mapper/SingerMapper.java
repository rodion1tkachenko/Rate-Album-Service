package ru.o0000q.ratealbumservice.mapper;

import org.springframework.stereotype.Component;
import ru.o0000q.ratealbumservice.dto.SingerDto;
import ru.o0000q.ratealbumservice.entity.Singer;
@Component
public class SingerMapper implements Mapper<Singer, SingerDto> {
    @Override
    public SingerDto fromEntityToDto(Singer object) {
        return SingerDto.builder()
                .id(object.getId())
                .name(object.getName())
                .albums(object.getAlbums())
                .build();
    }

    @Override
    public Singer fromDtoToEntity(SingerDto object) {
        return Singer.builder()
                .id(object.getId())
                .name(object.getName())
                .albums(object.getAlbums())
                .build();
    }
}
