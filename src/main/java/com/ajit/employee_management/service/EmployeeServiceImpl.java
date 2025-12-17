package com.ajit.employee_management.service;

import com.ajit.employee_management.entity.Employee;
import com.ajit.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employee update(Long id, Employee employee) {

        Employee existing  = repository.getReferenceById(id);
        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setSalary(employee.getSalary());

        return  repository.save(existing);

    }
}
