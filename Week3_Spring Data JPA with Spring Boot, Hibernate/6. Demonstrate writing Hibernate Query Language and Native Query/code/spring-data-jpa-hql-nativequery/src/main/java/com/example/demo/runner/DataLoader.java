package com.example.demo.runner;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    
    @Override
    public void run(String... args) {
        Employee emp1 = new Employee();
        emp1.setName("Alice");
        emp1.setDepartment("IT");
        emp1.setSalary(70000);

        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setDepartment("IT");
        emp2.setSalary(80000);

        Employee emp3 = new Employee();
        emp3.setName("Charlie");
        emp3.setDepartment("HR");
        emp3.setSalary(50000);

        Employee emp4 = new Employee();
        emp4.setName("Diana");
        emp4.setDepartment("Finance");
        emp4.setSalary(60000);

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
        employeeRepository.save(emp4);

        List<Employee> itEmployees = employeeRepository.findByDepartment("IT");
        System.out.println("IT Department Employees: " + itEmployees);

        Double avgSalary = employeeRepository.findAverageSalaryByDepartment("IT");
        System.out.println("Average IT Salary: " + avgSalary);

        List<Employee> highEarners = employeeRepository.findHighEarners(60000);
        System.out.println("High Earners: " + highEarners);
    }

}
