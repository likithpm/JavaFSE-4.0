package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByLastNameContaining(String fragment);
    List<Person> findByLastNameContainingOrderByAgeDesc(String fragment);
    List<Person> findByFirstNameStartsWith(String prefix);
    List<Person> findByCreatedDateBetween(LocalDate start, LocalDate end);
    List<Person> findByAgeGreaterThan(int age);
    List<Person> findByAgeLessThanEqual(int age);
    List<Person> findTop3ByOrderByAgeDesc();
}
