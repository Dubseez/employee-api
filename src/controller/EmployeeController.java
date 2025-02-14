package com.example.employeeapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        return Arrays.asList(
                new Employee(1, "John Doe", "Software Engineer", "IT"),
                new Employee(2, "Jane Smith", "HR Manager", "Human Resources")
        );
    }

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        if (id == 1) {
            return ResponseEntity.ok(new Employee(1, "John Doe", "Software Engineer", "IT"));
        } else if (id == 2) {
            return ResponseEntity.ok(new Employee(2, "Jane Smith", "HR Manager", "Human Resources"));
        }

        // Return 404 Not Found if employee does not exist
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}

