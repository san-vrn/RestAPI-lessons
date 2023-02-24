package com.rest.api.app.controlller;

import com.rest.api.app.entity.Employee;
import com.rest.api.app.exeption.handling.EmployeeIncorrectData;
import com.rest.api.app.exeption.handling.NoSuchEmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlerException(
            NoSuchEmployeeException employeeException){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(employeeException.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlerException(
            Exception exception){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
