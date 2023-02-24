package com.rest.api.app.dao;

import com.rest.api.app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
