package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL (HQL) - simple select
    @Query("SELECT e FROM Employee e WHERE e.department = :dept")
    List<Employee> findByDepartment(@Param("dept") String dept);

    // HQL with fetch keyword (not required here but applicable with relationships)

    // HQL aggregate function
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department = :dept")
    Double findAverageSalaryByDepartment(@Param("dept") String dept);

    // Native Query
    @Query(value = "SELECT * FROM employee WHERE salary > :minSalary", nativeQuery = true)
    List<Employee> findHighEarners(@Param("minSalary") double minSalary);
}
