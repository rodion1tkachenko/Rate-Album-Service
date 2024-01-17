package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.o0000q.ratealbumservice.dto.SingerDto;
import ru.o0000q.ratealbumservice.entity.Singer;
import ru.o0000q.ratealbumservice.mapper.SingerMapper;
import ru.o0000q.ratealbumservice.repository.SingerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SingerService {
    private final SingerRepository singerRepository;
    private final SingerMapper singerMapper;

    public Optional<SingerDto> getSingerByName(String name) {
        Singer singer = singerRepository.getSingerByName(name);
        if (singer == null) {
            return Optional.empty();
        }
        return Optional.of(singerMapper
                .fromEntityToDto(singerRepository
                        .getSingerByName(name)));
    }

    public Optional<SingerDto> getSingerById(Long id) {
        Singer singer = singerRepository.getSingerById(id);
        if(singer==null){
            return Optional.empty();
        }
        return Optional.of(singerMapper
                .fromEntityToDto(singer));
    }

    public List<SingerDto> findAll() {
        List<SingerDto> singers = new ArrayList<>();
        singerRepository.findAll()
                .forEach(singer -> singers
                    .add(singerMapper.fromEntityToDto(singer)));
        return singers;
    }

    @Transactional
    public void setSingerInfo(SingerDto singerDto) {
        if(singerDto==null){
            throw new NoSuchElementException("you're trying to save singer with wrong data");
        }
        singerRepository.setSingerInfo(singerDto.getName(),
                singerDto.getId());
    }

    @Transactional
    public void deleteById(Long id) {
        singerRepository.deleteById(id);
    }

    public void save(SingerDto singerDto) {
        singerRepository.save(singerMapper
                .fromDtoToEntity(singerDto));
    }
}
