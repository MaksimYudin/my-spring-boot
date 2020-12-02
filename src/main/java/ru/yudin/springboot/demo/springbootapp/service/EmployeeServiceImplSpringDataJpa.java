package ru.yudin.springboot.demo.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yudin.springboot.demo.springbootapp.dao.EmployeeDAO;
import ru.yudin.springboot.demo.springbootapp.dao.EmployeeRepository;
import ru.yudin.springboot.demo.springbootapp.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplSpringDataJpa implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplSpringDataJpa(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> empl = employeeRepository.findById(id);

        Employee employee = null;
        if (empl.isPresent())
            employee = empl.get();
        else
            throw new RuntimeException("Employee id not found - " + id);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
