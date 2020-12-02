package ru.yudin.springboot.demo.springbootapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.yudin.springboot.demo.springbootapp.dao.EmployeeDAO;
import ru.yudin.springboot.demo.springbootapp.entity.Employee;
import ru.yudin.springboot.demo.springbootapp.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(@Qualifier("employeeServiceImplJPAVersion") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            throw new RuntimeException("Employee id not found - " + employeeId);

        return employee;

    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null)
            throw new RuntimeException("Employee id not found - " + id);

        employeeService.deleteById(id);

        return "Employee id = " + id + " was deleted.";

    }
}
