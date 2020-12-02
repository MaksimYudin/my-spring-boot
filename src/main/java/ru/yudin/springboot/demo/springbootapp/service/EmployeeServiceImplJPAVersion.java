package ru.yudin.springboot.demo.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yudin.springboot.demo.springbootapp.dao.EmployeeDAO;
import ru.yudin.springboot.demo.springbootapp.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImplJPAVersion implements EmployeeService {
    private EmployeeDAO employeeDAO;

    // Set which bean will be used
    @Autowired
    public EmployeeServiceImplJPAVersion(@Qualifier("employeeDAOJpaIml") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.finadAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.delete(id);
    }
}
