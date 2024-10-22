package com.filmon.employeemanager.services;

import java.sql.Date;
import java.util.List;

import com.filmon.employeemanager.model.Employee;

public interface EmployeeDAO {
    
    Employee create(Employee employee);
    void deleteById(long id);
    void update(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);


    // public List<Employee> getEmployeesByDepartment(String department);
    // public List<Employee> getEmployeesByManager(String manager);
    // public List<Employee> getEmployeesByTitle(String title);
    // public List<Employee> getEmployeesBySalary(int salary);
    // public List<Employee> getEmployeesByHireDate(Date hireDate);
    // public List<Employee> getEmployeesByBirthDate(Date birthDate);
  



}
