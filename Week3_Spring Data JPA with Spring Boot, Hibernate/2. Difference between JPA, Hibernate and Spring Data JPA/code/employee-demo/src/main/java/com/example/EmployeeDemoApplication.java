package com.example;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDemoApplication.class);
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeeDemoApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        LOGGER.info("Inside main()");
        testAddEmployee(); // <- Add this line
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");

        Employee emp = new Employee();
        emp.setName("Alice");
        emp.setDepartment("IT");

        employeeService.addEmployee(emp); // <- Save employee

        LOGGER.info("Added employee: {}", emp);
        LOGGER.info("End");
    }
}
