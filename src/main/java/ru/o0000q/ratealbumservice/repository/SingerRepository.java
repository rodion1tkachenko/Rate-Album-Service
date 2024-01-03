package ru.o0000q.ratealbumservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.o0000q.ratealbumservice.entity.Singer;

public interface SingerRepository extends JpaRepository<Singer,Long> {
    default void saveSinger(Singer singer){
        save(singer);
    }
    Singer getSingerByName(String name);
}
