package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{
@Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
@ManyToOne
    private Movie movie;
    private Cinema cinema;
}
