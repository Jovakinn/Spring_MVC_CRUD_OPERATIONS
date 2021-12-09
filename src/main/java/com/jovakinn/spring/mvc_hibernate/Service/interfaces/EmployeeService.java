package com.jovakinn.spring.mvc_hibernate.Service.interfaces;

import com.jovakinn.spring.mvc_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(Integer id);
    public void deleteEmployee(Integer id);
}
