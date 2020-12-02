package ru.yudin.springboot.demo.springbootapp.dao;

import ru.yudin.springboot.demo.springbootapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> finadAll();

    Employee findById(int id);

    void save(Employee employee);

    void delete(int id);
}
