package com.example.soni.springbootrestapi.dao;

import com.example.soni.springbootrestapi.exception.EmployeeNotFoundException;
import com.example.soni.springbootrestapi.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> get() {
        String sql = "from Employee";

        Session session = entityManager.unwrap(Session.class);
        Query query =session.createQuery(sql, Employee.class);
        List<Employee> employeeList =query.list();

        System.out.println("employeeList size = "+employeeList.size());
        return employeeList;
    }

    @Override
    public Employee get(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        if(null == employee){
            throw new EmployeeNotFoundException("Employee not found for id : "+id);
        }
        System.out.println(employee);
        return employee;
    }

    @Override
    public Employee create(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        int id = (int) session.save(employee);
        System.out.println("id = "+id);
        Employee employee1 = session.load(Employee.class, id);
        return employee1;
    }

    @Override
    public void update(int id, Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.update(employee);

    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        if(null == employee){
            throw new EmployeeNotFoundException("Employee not found for id : "+id);
        }
        session.delete(employee);
    }
}
