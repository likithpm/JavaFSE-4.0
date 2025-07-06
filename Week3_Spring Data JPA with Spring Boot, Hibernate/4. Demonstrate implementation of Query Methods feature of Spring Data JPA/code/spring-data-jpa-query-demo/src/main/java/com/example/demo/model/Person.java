package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate createdDate;

    public Person() {}

    public Person(String firstName, String lastName, int age, LocalDate createdDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.createdDate = createdDate;
    }

    // Getters and setters omitted for brevity

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
}
