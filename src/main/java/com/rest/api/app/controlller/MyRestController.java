package com.rest.api.app.controlller;

import com.rest.api.app.entity.Employee;
import com.rest.api.app.exeption.handling.EmployeeIncorrectData;
import com.rest.api.app.exeption.handling.NoSuchEmployeeException;
import com.rest.api.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        if(employees.isEmpty()){throw new NoSuchEmployeeException("Работники еще не добавлены");}
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable(name = "id") int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee==null){throw new NoSuchEmployeeException("Работника с id " + id + " не существует");}
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "Работник с id "+ id + " удален";
    }
}
