package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.mapper.AlbumMapper;
import ru.o0000q.ratealbumservice.repository.AlbumRepository;
import ru.o0000q.ratealbumservice.repository.SingerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final SingerRepository singerRepository;
    public void saveAlbum(Album album) {
        singerRepository.save(album.getSinger());
        albumRepository.saveAlbum(album);
    }

    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.getAlbumById(id);
    }

    public Optional<Album> getAlbumByTitle(String string) {
        return albumRepository.getAlbumByTitle(string);
    }


    public void setAlbumInfo(Album album) {
        albumRepository.setAlbumInfo(album.getTitle(),
                album.getGenre(),
                album.getCover(),
                album.getId());
    }

    public void deleteAlbumById(Long id) {
        albumRepository.deleteAlbumById(id);
    }


}
