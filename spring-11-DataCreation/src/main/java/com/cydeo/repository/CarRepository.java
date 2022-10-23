package com.cydeo.repository;

import com.cydeo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //spring creates a class for us in runtime, but @Repository is no longer needed
public interface CarRepository extends JpaRepository <Car,Long> {
    // Car stands for the class, from which the table is created and data it will be related to
    //we created interface, because if it was class, we would have to write implementation, but it is already written
// save looks for a table where it will be added with SQL code


    //custom method. But how to write down impl if it is abtsract ? => Queries
}
