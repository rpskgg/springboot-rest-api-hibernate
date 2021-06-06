package com.example.soni.springbootrestapi.service;

import com.example.soni.springbootrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> get();
    Employee get(int id);
    Employee create(Employee employee);
    void update(int id, Employee employee);
    void delete(int id);
}
