package com.example.soni.springbootrestapi.service;

import com.example.soni.springbootrestapi.dao.EmployeeDao;
import com.example.soni.springbootrestapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> get() {
        return employeeDao.get();
    }

    @Override
    public Employee get(int id) {
        return employeeDao.get(id);
    }

    @Override
    public Employee create(Employee employee) {
        return employeeDao.create(employee);
    }

    @Override
    public void update(int id, Employee employee) {
        employeeDao.update(id, employee);
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }
}
