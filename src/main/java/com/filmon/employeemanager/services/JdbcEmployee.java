package com.filmon.employeemanager.services;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.filmon.employeemanager.model.Employee;


import java.util.List;

@Component
public class JdbcEmployee implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate; 
    
    
    public JdbcEmployee(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee create(Employee employee) {
        String sql = "INSERT INTO employeemanager (name, email, jobtitle, phone, imageurl, address, gender, employecode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(sql,
          employee.getName(),
          employee.getEmail(),
          employee.getJobTitle(),
          employee.getPhone(),
          employee.getImageUrl(),
          employee.getAddress(),
          employee.getGender(),
          employee.getEmployeCode());
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = null;
        String sql = "SELECT id, name, email, jobtitle, phone, imageurl, address, gender, employecode FROM employeemanager WHERE id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
        if (rows.next()) {
            employee = mapRowToEmployee(rows);
        }
        return employee;
    }

    private Employee mapRowToEmployee(SqlRowSet row) {
        Employee employee = new Employee();
        employee.setId(row.getLong("id"));
        employee.setName(row.getString("name"));
        employee.setEmail(row.getString("email"));
        employee.setJobTitle(row.getString("jobtitle"));
        employee.setPhone(row.getString("phone"));
        employee.setImageUrl(row.getString("imageurl"));
        employee.setAddress(row.getString("address"));
        employee.setGender(row.getString("gender"));
        employee.setEmployeCode(row.getString("employecode"));
        return employee;
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM employeemanager WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employeemanager SET name = ?, email = ?, jobtitle = ?, phone = ?, imageurl = ?, address = ?, gender = ?, employecode = ? WHERE id = ?";
        jdbcTemplate.update(sql,
          employee.getName(),
          employee.getEmail(),
          employee.getJobTitle(),
          employee.getPhone(),
          employee.getImageUrl(),
          employee.getAddress(),
          employee.getGender(),
          employee.getEmployeCode(),
          employee.getId());
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employeemanager";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setJobTitle(rs.getString("jobtitle"));
            employee.setPhone(rs.getString("phone"));
            employee.setImageUrl(rs.getString("imageurl"));
            employee.setAddress(rs.getString("address"));
            employee.setGender(rs.getString("gender"));
            employee.setEmployeCode(rs.getString("employecode"));
            return employee;
        });
    }
}
