package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    List<Cinema> findByName(String name);


    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country




    //Write a derived query to list all cinemas with a specific name or sponsored name
List<Cinema> findByNameOrSponsoredName(String name, String name2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
@Query("SELECT c.name FROM Cinema c WHERE c.id=?1")
    List<String> retrieveNameById(Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
@Query(value = "SELECT*FROM cinema WHERE name Like ?1 OR sponsored_name LIKE ?2 ",nativeQuery = true)
    List<Cinema> findCinemaByNames(String name,String sponsoredName);

    //Write a native query to sort all cinemas by name
    @Query(value="SELECT*FROM cinema ORDER BY name", nativeQuery = true)
List<Cinema> retrieveSortCinema();

    //Write a native query to distinct all cinemas by sponsored name
//    @Query(value="SELECT distinct sponsored_name FROM cinema ",nativeQuery = true)
//    List<Cinema> retrieveDistinct();


}
