package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
List<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findByPriceBetween(BigDecimal start, BigDecimal end);


    //Write a derived query to list all movies where duration exists in the specific list of duration


    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findByReleaseDateAfter(LocalDate date);


    //Write a derived query to list all movies with a specific state and type



    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
@Query("Select m from Movie m where m.price Between ?1 AND ?2")
    List<Movie> findByPriceRange(BigDecimal start, BigDecimal end);

    //Write a JPQL query that returns all movie names
@Query("select m.name FROM Movie m")
    List<String> findNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
@Query(value = "Select*from movie where name=?1",nativeQuery = true)
    List<String> findMovieBySelectedName(String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "Select*from movie where price between ?1 and ?2",nativeQuery = true)
    List<String> findMovieByPriceRange(BigDecimal one, BigDecimal two);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "Select*from movie where duration between ?1 and ?2",nativeQuery = true)
    List<String> findMovieByDurationRange(Integer one, Integer two);

    //Write a native query to list the top 5 most expensive movies

}
