package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.o0000q.ratealbumservice.entity.Singer;

import java.util.Optional;

public interface SingerRepository extends JpaRepository<Singer,Long> {
    default void saveSinger(Singer singer){
        save(singer);
    }
    Optional<Singer> getSingerByName(String name);
    Optional<Singer>getSingerById(Long id);
    @Modifying
    @Query("update Singer s " +
            "set s.name=?1 where s.id=?2")
    void setSingerInfo(String name, Long id);
    void deleteById(Long id);
}
