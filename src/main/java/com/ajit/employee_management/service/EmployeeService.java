package com.ajit.employee_management.service;

import com.ajit.employee_management.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    Employee create(Employee employee);
    Employee getById(Long id);
    List<Employee> getAll();
    void delete(Long id);
    Employee update(Long id, Employee employee);
}
