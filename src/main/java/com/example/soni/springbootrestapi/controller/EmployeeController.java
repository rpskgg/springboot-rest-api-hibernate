package com.example.soni.springbootrestapi.controller;

import com.example.soni.springbootrestapi.model.Employee;
import com.example.soni.springbootrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        List<Employee> employeeList = employeeService.get();
        for (Employee employee: employeeList){
            System.out.println(employee);
        }
        return employeeList;
    }

    @RequestMapping(method = GET, path = "/{id}")
    public Employee get(@PathVariable("id") int id) {
        System.out.println("entry get method : id = " + id);
        Employee employee = employeeService.get(id);
        return employee;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        System.out.println(employee);
        Employee employee1 = employeeService.create(employee);
        return employee1;
    }

    @PutMapping
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee.getId(), employee);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        System.out.println("employee deleted");
    }

}
