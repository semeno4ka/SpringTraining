package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer findByUserAccountId(Long id);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countByMovieCinemaMovieName(Movie movie);

    //Write a derived query to list all tickets between a range of dates
  List<Ticket> findByDateTimeBetween(LocalDateTime date1,LocalDateTime date2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id=?1 ")
    // can reach id since working with objects
    List<Ticket> fetchTicketsByUser(@Param("userId")Long id);


    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> fetchByDate(@Param("date1")LocalDateTime date,@Param("date2")LocalDateTime date2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT count(*) FROM ticket WHERE user_account_id=?1",nativeQuery = true)
    Integer countTicketsByUser(@Param("userID")Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT count(*) FROM ticket WHEREuser_account_id=?1 AND date_time BETWEEN ?2 AND ?3",nativeQuery = true)
    Integer countTicketsByDateRange(@Param("userId") Long id,@Param("date1") LocalDateTime date,@Param("date2") LocalDateTime date2);
    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT DISTINCT m.name FROM ticket t JOIN movie_cinema mc ON mc.id=t.movie_cinema JOIN movie m ON m.id=mc.movie_id",nativeQuery = true)
    List<Ticket> getUniqueTicketsByMovie();
    //Write a native query to find all tickets by user email
    @Query(value = "SELECT*FROM ticket t JOIN user_account ua ON t.user_account_id=ua.id WHERE ua.email=?1",nativeQuery = true)
    List<Ticket> findAllByEMail(@Param("email") String email);
    //Write a native query that returns all tickets
    @Query(value = "SELECT*FROM ticket",nativeQuery = true)
    List<Ticket> fetchAllTickets();
    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "SELECT*FROM ticket t JOIN user_account au ON t.user_account_id=au.id" +
            "JOIN account_details ad ON ad.id=au.account_details_id " +
            "JOIN movie_cinema mc ON t.movie_cinema_id=mc.id " +
            "JOIN movie m ON mc.movie_id=m.id " +
            "WHERE ua.username ILIKE concat ('%',?1,'%') " +
            "OR ad.name ILIKE concat ('%',?1,'%') " +
            "OR m.name ILIKE concat ('%',?1,'%')  ",nativeQuery = true)
    List<Ticket> listTicketsOnSpecificParam(@Param("pattern") String pattern);
}
