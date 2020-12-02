package ru.yudin.springboot.demo.springbootapp.service;

import ru.yudin.springboot.demo.springbootapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
