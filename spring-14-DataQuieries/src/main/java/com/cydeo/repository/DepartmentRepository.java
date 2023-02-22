package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {


    //all in furniture Dep
    List<Department> findByDepartment(String department);

    List<Department> findByDivision(String division);

    List<Department> findByDivisionIs(String division);

    List<Department> findByDivisionEquals(String division);

    List<Department> findByDivisionEndingWith(String str);

    List<Department> findDistinctTop3ByDivisionContains(String str);

    @Query(value = "SELECT*FROM departments WHERE division IN ?1 ", nativeQuery = true)
    List<Department> retrieveDepartmentDivision(List<String> division);// you pass a list of divisions as parameter

}
