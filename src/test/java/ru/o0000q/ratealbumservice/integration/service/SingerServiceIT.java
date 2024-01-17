package ru.o0000q.ratealbumservice.integration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.o0000q.ratealbumservice.dto.SingerDto;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.integration.IntegrationTestBase;
import ru.o0000q.ratealbumservice.mapper.SingerMapper;
import ru.o0000q.ratealbumservice.service.SingerService;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SingerServiceIT extends IntegrationTestBase {
    private SingerDto SINGER_QUAVO = SingerDto.builder()
            .name("Quavo")
            .build();
    private SingerDto SINGER_WITH_EXISTING_ID = SingerDto.builder()
            .name("Thug")
            .id(1L)
            .build();
    private SingerDto SINGER_FROM_DATABASE = SingerDto.builder()
            .name("Singer2")
            .id(2L)
            .build();

    @Autowired
    private SingerService singerService;
    @Autowired
    private SingerMapper singerMapper;

    @Test
    void methodShouldSaveSingerInDatabase() {
        singerService.save(SINGER_QUAVO);
        Optional<SingerDto> maybeSinger = singerService
                .getSingerByName(SINGER_QUAVO.getName());
        assertTrue(maybeSinger.isPresent());
        maybeSinger.ifPresent(actualSinger->
                assertAll(
                        () -> assertEquals(SINGER_QUAVO.getName(),actualSinger.getName()),
                        () -> assertEquals(SINGER_QUAVO.getAlbums(),actualSinger.getAlbums())
                ));
    }
    @Test
    void methodShouldSaveSingerWithExistingId() {
        singerService.save(SINGER_WITH_EXISTING_ID);
        Optional<SingerDto> maybeSingerAfterSave = singerService.getSingerById(1L);
        assertTrue(maybeSingerAfterSave.isPresent());
        maybeSingerAfterSave.ifPresent(actualSinger -> {
            assertAll(
                    () -> assertEquals(SINGER_WITH_EXISTING_ID.getId(), actualSinger.getId()),
                    () -> assertEquals(SINGER_WITH_EXISTING_ID.getName(), actualSinger.getName()),
                    () -> assertEquals(SINGER_WITH_EXISTING_ID.getAlbums(), actualSinger.getAlbums())

            );
        });
    }
    @Test
    void getSingerByIdShouldReturnAccurateSinger() {
        Optional<SingerDto> actualResult = singerService.getSingerById(2L);
        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(singer ->
                assertAll(
                        () -> assertEquals(SINGER_FROM_DATABASE.getId(), singer.getId()),
                        () -> assertEquals(SINGER_FROM_DATABASE.getAlbums(), singer.getAlbums()),
                        () -> assertEquals(SINGER_FROM_DATABASE.getName(), singer.getName())
                ));
    }
    @Test
    void twoGetSingerByIdInvokeShouldReturnDifferentSingers() {
        Optional<SingerDto> singer1 = singerService.getSingerById(1L);
        Optional<SingerDto> singer2 = singerService.getSingerById(2L);
        assertNotEquals(singer1, singer2);
    }
    @Test
    void twoGetSingerByNameInvokeShouldReturnDifferentSingers() {
        Optional<SingerDto> singer1 = singerService.getSingerByName("Singer1");
        Optional<SingerDto> singer2 = singerService.getSingerByName("Singer2");
        assertNotEquals(singer1, singer2);
    }
    @Test
    void getSingerByIdShouldReturnEmptyOptionalIfSingerIsNotInDatabase() {
        Optional<SingerDto> maybeSinger = singerService.getSingerById(3L);
        assertFalse(maybeSinger.isPresent());
    }

    @Test
    void getSingerByNameShouldReturnEmptyOptionalIfSingerIsNotInDatabase() {
        Optional<SingerDto> maybeSinger = singerService.getSingerByName("...?");
        assertFalse(maybeSinger.isPresent());

    }
    @Test
    void deleteByIdShouldDeleteSingerWithIdOne() {
        singerService.deleteById(1L);
        Optional<SingerDto> maybeSinger = singerService.getSingerById(1L);
        assertFalse(maybeSinger.isPresent());
    }
    @Test
    void deleteByIdShouldNotDeleteSingerBecauseNoSuchSingerInDatabase() {
        singerService.deleteById(3L);
        assertEquals(singerService.findAll().size(),2);
    }

    @Test
    void findAllShouldHasCorrectSinger() {
        assertTrue(singerService.findAll().contains(SINGER_FROM_DATABASE));
    }
    @Test
    void methodShouldNotUpdateSingerIfEntityIsNotInDatabase(){
        singerService.setSingerInfo(SINGER_QUAVO);
        Optional<SingerDto> maybeSinger = singerService
                .getSingerByName(SINGER_QUAVO.getName());
        assertFalse(maybeSinger.isPresent());
    }
    @Test
    void methodUpdateShouldSuccessfulUpdateSingerFromDatabase(){
        singerService.setSingerInfo(SINGER_WITH_EXISTING_ID);
        Optional<SingerDto> maybeSinger = singerService
                .getSingerByName(SINGER_WITH_EXISTING_ID.getName());
        assertTrue(maybeSinger.isPresent());
        maybeSinger.ifPresent(actualSinger->{
            assertAll(
                    () -> assertEquals(SINGER_WITH_EXISTING_ID.getId(), actualSinger.getId()),
                    () -> assertEquals(SINGER_WITH_EXISTING_ID.getName(), actualSinger.getName())
            );
        });
    }
}