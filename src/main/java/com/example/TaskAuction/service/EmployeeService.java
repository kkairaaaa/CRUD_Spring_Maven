package com.example.TaskAuction.service;


import com.example.TaskAuction.data.models.Employee;
import com.example.TaskAuction.data.payloads.request.EmployeeRequest;
import com.example.TaskAuction.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


//Component не нужен
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);
    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
    void deleteEmployee(Integer employeeId);
    Employee getASingleEmployee(Integer employeeId);
    List<Employee> getAllEmployee();
}