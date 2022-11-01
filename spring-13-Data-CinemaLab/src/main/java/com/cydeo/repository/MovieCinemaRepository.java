package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> readAllById(Long id);


    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countByCinemaId(Long id);


    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countByMovieId(Long id);


    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeAfter(LocalDateTime date);


    //Write a derived query to find the top 3 expensive movies
    List<Movie> findTop3OrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovieNameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinemaLocationName(String name);//go to Cinema, since MovieCinema doesn't have location

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("Select m FROM MovieCinema m WHERE m.dateTime>?1")
    List<MovieCinema> retrieveByDateHigherThan(@Param("date") LocalDateTime date);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
@Query(value="SELECT count(*) FROM movie_cinema where cinema_id=?1",nativeQuery = true)
    Integer countById(@Param("id") Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT*FROM movie_cinema mc JOIN cinema c ON c.id=mc.cinema_id JOIN location l ON l.id=c.location_id " +
            "WHERE l.name=?1 ",nativeQuery = true)
    List<MovieCinema> retrieveByLocation(@Param("location") String name);

}
