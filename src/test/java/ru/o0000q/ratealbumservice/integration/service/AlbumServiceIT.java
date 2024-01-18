package ru.o0000q.ratealbumservice.integration.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.Singer;
import ru.o0000q.ratealbumservice.integration.IntegrationTestBase;
import ru.o0000q.ratealbumservice.mapper.AlbumMapper;
import ru.o0000q.ratealbumservice.repository.AlbumRepository;
import ru.o0000q.ratealbumservice.service.AlbumService;
import ru.o0000q.ratealbumservice.service.SingerService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AlbumServiceIT extends IntegrationTestBase {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SingerService singerService;

    @Autowired
    private AlbumService albumService;

    private Singer SINGER_ONE= Singer.builder()
            .name("MIKE")
            .build();
    private Album VALID_ALBUM_NOT_FROM_DATABASE = Album.builder()
            .title("AFRO")
            .singer(SINGER_ONE)
            .genre("Rap")
            .build();
    private Album INVALID_ALBUM_NOT_FROM_DATABASE = Album.builder()
            .title("unknown")
            .genre("Rap")
            .build();
    private Album ALBUM_WITH_EXISTING_ID_IN_DATABASE = Album.builder()
            .id(1L)
            .title("NEW_ALBUM")
            .genre("Rap")
            .build();

    @Test
    void saveAlbum_ValidAlbum_AlbumSaved() {
        // Arrange
        albumService.saveAlbum(VALID_ALBUM_NOT_FROM_DATABASE);
        Optional<Album> savedAlbum = albumService.getAlbumById(VALID_ALBUM_NOT_FROM_DATABASE.getId());
        assertTrue(savedAlbum.isPresent());
        assertEquals(VALID_ALBUM_NOT_FROM_DATABASE.getTitle(), savedAlbum.get().getTitle());

    }
    @Test
    void saveAlbum_InvalidAlbum_AlbumIsNotSaved() {
        // Arrange
        assertThrows(Throwable.class,
                ()->albumService.saveAlbum(INVALID_ALBUM_NOT_FROM_DATABASE));
//        Optional<Album> savedAlbum = albumService.getAlbumByTitle(VALID_ALBUM_NOT_FROM_DATABASE.getTitle());
//        assertFalse(savedAlbum.isPresent());
    }

    @Test
    void getAlbumById_ExistingId_ReturnsAlbum() {
        // Arrange
        Long id = 1L;
        // Act
        Optional<Album> maybeAlbum = albumService.getAlbumById(id);
        assertTrue(maybeAlbum.isPresent());
        // Additional assertions as needed
    }

    @Test
    void getAlbumById_NonExistingId_ReturnsEmptyOptional() {
        Long id = 3L;
        // Act
        Optional<Album> result = albumService.getAlbumById(id);
        // Assert
        assertFalse(result.isPresent());
    }

    // Similar tests for other methods
    @Test
    void deleteAlbumById_ExistingId_ReturnsTrue() {
        Long id = 1L;
        albumService.deleteAlbumById(id);
        assertFalse(albumRepository.existsById(id));
    }

    @Test
    void deleteAlbumById_NonExistingId_ReturnsFalse() {
        albumService.deleteAlbumById(3L);
        assertTrue(albumService.getAlbumById(3L).isEmpty());
    }
    @Test
    void updateNonExistingUserShouldReturnEmptyOptional(){
        ALBUM_WITH_EXISTING_ID_IN_DATABASE.setId(999L);
        albumService.setAlbumInfo(ALBUM_WITH_EXISTING_ID_IN_DATABASE);
        Optional<Album> actualAlbum = albumService.getAlbumById(999L);
        assertFalse(actualAlbum.isPresent());
//        assertAll(
//                ()->assertTrue(actualAlbum.isPresent()),
//                ()->assertTrue(albumService
//                        .getAlbumByTitle(ALBUM_WITH_EXISTING_ID_IN_DATABASE
//                        .getTitle())
//                        .isPresent()),
//                ()->assertEquals( actualAlbum.get().getTitle(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getTitle()),
//                ()->assertEquals( actualAlbum.get().getUsersRatings(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getUsersRatings()),
//                ()->assertEquals( actualAlbum.get().getGenre(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getGenre()),
//                ()->assertEquals( actualAlbum.get().getCover(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getCover()),
//                ()->assertEquals( actualAlbum.get().getId(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getId())
//        );
    }
    @Test
    void updateExistingUserShouldUpdateSuccessfully(){
        albumService.setAlbumInfo(ALBUM_WITH_EXISTING_ID_IN_DATABASE);
        Optional<Album> actualAlbum = albumService.getAlbumById(1L);
        assertAll(
                ()->assertTrue(actualAlbum.isPresent()),
                ()->assertTrue(albumService
                        .getAlbumByTitle(ALBUM_WITH_EXISTING_ID_IN_DATABASE
                        .getTitle())
                        .isPresent()),
                ()->assertEquals( actualAlbum.get().getTitle(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getTitle()),
                ()-> assertIterableEquals(actualAlbum.get().getUsersRatings(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getUsersRatings()),
                ()->assertEquals( actualAlbum.get().getGenre(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getGenre()),
                ()->assertEquals( actualAlbum.get().getCover(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getCover()),
                ()->assertEquals( actualAlbum.get().getId(), ALBUM_WITH_EXISTING_ID_IN_DATABASE.getId())
        );
    }
}
