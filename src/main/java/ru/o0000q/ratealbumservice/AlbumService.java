package ru.o0000q.ratealbumservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.repository.AlbumRepository;
import ru.o0000q.ratealbumservice.repository.SingerRepository;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final SingerRepository singerRepository;


    public void saveAlbum(Album album) {
        singerRepository.saveSinger(album.getSinger());
        albumRepository.saveAlbum(album);
    }
}
