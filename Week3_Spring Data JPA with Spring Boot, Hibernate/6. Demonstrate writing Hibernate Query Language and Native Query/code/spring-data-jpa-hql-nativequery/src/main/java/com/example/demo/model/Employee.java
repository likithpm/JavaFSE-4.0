package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String department;
    private double salary;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return name + " - " + department + " - " + salary;
    }
}
