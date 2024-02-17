package ru.o0000q.ratealbumservice.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import ru.o0000q.ratealbumservice.entity.Singer;
import ru.o0000q.ratealbumservice.entity.UsersRating;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class AlbumDto {
    private Long id;
    private String title;
    private byte[] cover;
    private String genre;
    private Singer singer;
    private List<UsersRating> usersRatings;

}
