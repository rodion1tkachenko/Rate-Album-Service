package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.repository.AlbumRepository;
import ru.o0000q.ratealbumservice.repository.SingerRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final SingerRepository singerRepository;


    public void saveAlbum(Album album) {
        singerRepository.saveSinger(album.getSinger());
        albumRepository.saveAlbum(album);
    }

    public Album getAlbumById(Long id) {
        return albumRepository.getAlbumById(id);
    }
}
