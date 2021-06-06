package com.example.soni.springbootrestapi.dao;


import com.example.soni.springbootrestapi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> get();
    Employee get(int id);
    Employee create(Employee employee);
    void update(int id, Employee employee);
    void delete(int id);
}
