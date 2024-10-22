package com.filmon.employeemanager.contollers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.filmon.employeemanager.model.Employee;
import com.filmon.employeemanager.services.EmployeeDAO;


// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    // private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeDAO employeeDAO;

  
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeDAO.create(employee);
    }
    // @PostMapping("/create")
    // public Employee create(@RequestBody Employee employee) {
    //     logger.info("Creating new employee: {}", employee);
    //     Employee createdEmployee = employeeDAO.create(employee);
    //     logger.info("Created employee: {}", createdEmployee);
    //     return createdEmployee;
    // }

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeDAO.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Employee employee) {
        employeeDAO.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        employeeDAO.deleteById(id);
    }

   
}
