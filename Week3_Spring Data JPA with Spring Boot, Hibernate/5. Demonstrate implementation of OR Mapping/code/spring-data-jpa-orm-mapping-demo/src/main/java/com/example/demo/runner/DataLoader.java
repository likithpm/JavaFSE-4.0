package com.example.demo.runner;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final DepartmentRepository deptRepo;
    private final EmployeeRepository empRepo;
    private final ProjectRepository projRepo;

    public DataLoader(DepartmentRepository deptRepo, EmployeeRepository empRepo, ProjectRepository projRepo) {
        this.deptRepo = deptRepo;
        this.empRepo = empRepo;
        this.projRepo = projRepo;
    }

    @Override
    public void run(String... args) {
        Department d1 = new Department();
        d1.setName("IT");
        deptRepo.save(d1);

        Project p1 = new Project();
        p1.setTitle("Alpha");
        Project p2 = new Project();
        p2.setTitle("Beta");
        projRepo.saveAll(Arrays.asList(p1, p2));

        Employee e1 = new Employee();
        e1.setName("Alice");
        e1.setDepartment(d1);
        e1.setProjects(new HashSet<>(Arrays.asList(p1, p2)));

        Employee e2 = new Employee();
        e2.setName("Bob");
        e2.setDepartment(d1);
        e2.setProjects(new HashSet<>(Arrays.asList(p2)));

        empRepo.saveAll(Arrays.asList(e1, e2));
    }
}
