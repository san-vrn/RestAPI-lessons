package com.rest.api.app.service;


import com.rest.api.app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
