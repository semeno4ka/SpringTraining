package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Spring13DataCinemaLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring13DataCinemaLabApplication.class, args);
    }

 //   @Bean
   // public MigrateResult migrateResult(DataSource dataSource){
     //   return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    //}// whenever we put flyway dependency, it is looking for dataSource in app.properties. For that, tables should be created, but this way we define bean where to look for data

}
