package com.jovakinn.spring.mvc_hibernate.DAO.Interfaces;

import com.jovakinn.spring.mvc_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(Integer id);

    public void deleteEmployee(Integer id);
}
