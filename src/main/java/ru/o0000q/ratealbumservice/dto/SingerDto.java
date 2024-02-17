package ru.o0000q.ratealbumservice.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import ru.o0000q.ratealbumservice.entity.Album;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class SingerDto {
    private Long id;
    private String name;
    @Builder.Default
    private List<Album>albums=new ArrayList<>() ;
}
