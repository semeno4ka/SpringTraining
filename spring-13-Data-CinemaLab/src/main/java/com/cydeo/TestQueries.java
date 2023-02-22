package com.cydeo;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.cydeo.enums.MovieState.ACTIVE;
import static com.cydeo.enums.MovieType.PREMIER;

@Component
public class TestQueries implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;

    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TestQueries(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------------------ACCOUNT---------------------------");
        System.out.println("findByCountryOrState" + accountRepository.findByCountryOrState("United States", "Brooklyn"));
        System.out.println("findByAgeLessThanEqual" + accountRepository.findByAgeLessThanEqual(35));
        System.out.println("findByRole" + accountRepository.findByRole(UserRole.USER));
        System.out.println("findByAgeBetween" + accountRepository.findByAgeBetween(30, 45));
        System.out.println("findByAddressStartingWith" + accountRepository.findByAddressStartsWith("262"));
        System.out.println("findByOrderByAge" + accountRepository.findByOrderByAge());
        //find by age and sort by age
        System.out.println("retrieveAccounts" + accountRepository.retrieveAccounts());
        System.out.println("retrieveAdminAccount" + accountRepository.retrieveAdminAccount());
        System.out.println("retrieveAccountWithAgeSort" + accountRepository.retrieveAccountWithAgeSort());
        System.out.println("retrieveAccountWithAgeLessThan" + accountRepository.retrieveAccountWithAgeLessThan(35));
// retireve if contains specific
        System.out.println("retrieveAgeGreaterThan" + accountRepository.retrieveAgeGreaterThan(35));
        System.out.println("--------------------CINEMA---------------------------");
        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println("findTop3BySponsoredNameContainingOrderBySponsoredName" + cinemaRepository.findTop3BySponsoredNameContainingOrderBySponsoredName("Kodak"));
        //  System.out.println("findByCountry"+cinemaRepository.findByLocationEquals("United States"));
        System.out.println("findByNameOrSponsoredName" + cinemaRepository.findByNameOrSponsoredName("Empire", "Kodak"));
        System.out.println("retrieveNameById" + cinemaRepository.retrieveNameById(2L));
        System.out.println("findCinemaByNames" + cinemaRepository.findCinemaByNames("EMPIRE"));
        System.out.println("retrieveSortCinema" + cinemaRepository.retrieveSortCinema());
        //distinct
        System.out.println("------------------GENRE-------------------");
        System.out.println("readALl" + genreRepository.findAll());
        System.out.println("retrieveByName" + genreRepository.retrieveByName("Comedy"));
        System.out.println("------------------MovieCinemaRepository-------------------");
        System.out.println("readAllById" + movieCinemaRepository.readAllById(2L));
        System.out.println("countById" + movieCinemaRepository.countById(12L));
        System.out.println("-------------------MOVIE----------------------");
        System.out.println("findByName" + movieRepository.findByName("Tenet"));
        System.out.println("findByPriceBetween" + movieRepository.findByPriceBetween(new BigDecimal(10), new BigDecimal(20)));
        System.out.println("findByReleaseDateAfter" + movieRepository.findByReleaseDateAfter(LocalDate.of(2019, 10, 12)));
        System.out.println("findByPriceRange" + movieRepository.findByPriceRange(new BigDecimal(10), new BigDecimal(20)));
        System.out.println("findNames" + movieRepository.findNames());
        System.out.println("findMovieBySelectedName" + movieRepository.findMovieBySelectedName("Tenet"));
        System.out.println("findMovieByPriceRange" + movieRepository.findMovieByPriceRange(new BigDecimal(10), new BigDecimal(20)));
        System.out.println("-------------------USER--------------------");
        System.out.println("findByEmail" + userRepository.findByEmail("josie_story@email.com"));
        System.out.println("findByUsername" + userRepository.findByUsername("josieStory"));
        System.out.println("findByName" + userRepository.findByAccountNameContaining("faith"));
        System.out.println("findByUsernameContainingIgnoreCase" + userRepository.findAllByAccountNameContainingIgnoreCase("faith"));
        System.out.println("findBySpecificEmail" + userRepository.findBySpecificEmail("josie_story@email.com"));
        System.out.println("selectAllUser" + userRepository.selectAllUser());
        System.out.println("selectAllUserAgain" + userRepository.selectAllUserAgain());
        System.out.println("selectAllUserContaining" + userRepository.retrieveAllByName("faith"));
        System.out.println("selectByEmail" + userRepository.retrieveByEmail("josie_story@email.com"));

    }
}
