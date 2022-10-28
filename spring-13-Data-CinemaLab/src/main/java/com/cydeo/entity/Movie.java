package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor


public class Movie extends BaseEntity {

    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private Integer duration;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Enumerated(EnumType.STRING)
    private MovieState state;
    private BigDecimal price;
    @ManyToMany
    //for third table created from movie and genre, specify the name of the table and columns
    @JoinTable(name = "movie_genre-rel",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns=@JoinColumn(name ="genre_id"))
    private List<Genre> genreList;
    /*if we use List, in case of deletion, all will be deleted, and then added again, except the one we wanted to delete
    If you use Set, it will delete the specified book from the auther, query will be more specific behind the scene
     */




}
