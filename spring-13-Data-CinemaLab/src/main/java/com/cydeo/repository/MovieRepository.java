package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findByPriceBetween(BigDecimal start, BigDecimal end);


    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findByDurationIn(List<Integer> durationList);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findByReleaseDateAfter(LocalDate date);


    //Write a derived query to list all movies with a specific state and type
    List<Movie> findByStateAndType(MovieState state, MovieType type);
    // field, not class for this query in method name (State and Type not MovieState and MovieType)

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("Select m from Movie m where m.price Between ?1 AND ?2")
    List<Movie> findByPriceRange(@Param("price1") BigDecimal start, @Param("price2") BigDecimal end);

    //Write a JPQL query that returns all movie names
    @Query("SELECT DISTINCT m.name FROM Movie m")
    List<String> findNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT*FROM movie WHERE name=?1", nativeQuery = true)
    Optional<Movie> findMovieBySelectedName(@Param("name") String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT*FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<String> findMovieByPriceRange(@Param("price1") BigDecimal one, @Param("price2") BigDecimal two);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT*FROM movie WHERE duration IN ?1", nativeQuery = true)
    List<String> findMovieByDurationRange(@Param("durations") List<Integer> durations);

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "SELECT*FROM movie ORDER BY price Desc limit 5", nativeQuery = true)
    List<Movie> mostExpensiveFive();

}
