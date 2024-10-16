package com.filmon.employeemanager.services;

import java.sql.Date;
import java.util.List;

import com.filmon.employeemanager.model.Employee;

public interface employeeDAO {
    
    public void saveEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(int id);
    public List<Employee> getEmployeesByDepartment(String department);
    public List<Employee> getEmployeesByManager(String manager);
    public List<Employee> getEmployeesByTitle(String title);
    public List<Employee> getEmployeesBySalary(int salary);
    public List<Employee> getEmployeesByHireDate(Date hireDate);
    public List<Employee> getEmployeesByBirthDate(Date birthDate);
  



}
