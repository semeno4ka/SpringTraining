package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //all with email ""
    List<Employee> findByEmail(String email);

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);

    List<Employee> findByFirstNameIsNot(String firstName);

    List<Employee> findByLastNameStartingWith(String str);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalaryLessThan(Integer salary);

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    List<Employee> findByEmailIsNull();

    @Query("SELECT e FROM Employee e where e.id=9 ")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.id=10")
    Integer retrieveEmployeeSalary();


    @Query("SELECT e.salary FROM Employee e WHERE e.salary <>?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    @Query("SELECT e.firstName FROM Employee e WHERE e.firstName like ?1")
    List<Employee> retrieveEmployeeNameStartsWith(String pattern);


    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<String> retrieveEmployeeSalaryLessThan(int salary);

    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<String> retrieveEmployeeWithSalaryBetween(int range, int range2);

    @Query("SELECT e FROM Employee e WHERE e.hireDate>?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
//IS  NULL
    List<Employee> retrieveEmployeeEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
//IS NOT NULL
    List<Employee> retrieveEmployeeEmailIsNotNull();

    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native Query
    @Query(value = "SELECT*FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //Named Parameter
    @Query("SELECT e FROM Employee e WHERE e.salary= :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);


}
