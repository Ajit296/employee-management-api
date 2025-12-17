package com.ajit.employee_management.controller;

import com.ajit.employee_management.entity.Employee;
import com.ajit.employee_management.service.EmployeeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@SecurityRequirement(name = "bearerAuth")
public class EmployeeController {

    @Autowired
   private EmployeeService service;

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id){

            return service.getById(id);
    }
    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee){

        return new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAll(){
      return service.getAll();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee){

        return service.update(id,employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
