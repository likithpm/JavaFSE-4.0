package com.example.demo.runner;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataRunner implements CommandLineRunner {
    private final PersonRepository repo;

    public DataRunner(PersonRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Person("John", "Doe", 30, LocalDate.of(2023,1,1)));
        repo.save(new Person("Jane", "Doe", 25, LocalDate.of(2024,6,15)));
        repo.save(new Person("Alice", "Smith", 35, LocalDate.of(2025,1,10)));
        repo.save(new Person("Bob", "Johnson", 40, LocalDate.of(2025,3,20)));
        repo.save(new Person("Charlie", "Doe", 20, LocalDate.of(2025,5,5)));

        System.out.println("Containing 'Doe': " + repo.findByLastNameContaining("Doe"));
        System.out.println("Sorted containing 'Doe': " + repo.findByLastNameContainingOrderByAgeDesc("Doe"));
        System.out.println("StartsWith 'J': " + repo.findByFirstNameStartsWith("J"));
        System.out.println("Created between 2024-01 and 2025-06: " +
          repo.findByCreatedDateBetween(LocalDate.of(2024,1,1), LocalDate.of(2025,6,30)));
        System.out.println("Age > 30: " + repo.findByAgeGreaterThan(30));
        System.out.println("Age <= 30: " + repo.findByAgeLessThanEqual(30));
        System.out.println("Top 3 by age desc: " + repo.findTop3ByOrderByAgeDesc());
    }
}
