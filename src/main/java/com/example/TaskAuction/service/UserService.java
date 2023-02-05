package com.example.TaskAuction.service;


import com.example.TaskAuction.data.models.User;
import com.example.TaskAuction.data.payloads.request.UserRequest;
import com.example.TaskAuction.data.payloads.response.MessageResponse;

import java.util.List;
import java.util.Optional;


//Component не нужен
public interface UserService {
    MessageResponse createEmployee(UserRequest userRequest);
    Optional<User> updateEmployee(Integer employeeId, UserRequest userRequest);
    void deleteEmployee(Integer employeeId);
    User getASingleEmployee(Integer employeeId);
    List<User> getAllEmployee();
}