package ru.o0000q.ratealbumservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "albums")
@ToString(exclude = "albums")
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "singer",cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @Builder.Default
    private List<Album>albums=new ArrayList<>() ;
}
