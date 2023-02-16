package com.example.TaskAuction.service;


import com.example.TaskAuction.data.models.User;
import com.example.TaskAuction.data.payloads.request.UserRequest;
import com.example.TaskAuction.data.payloads.response.MessageResponse;
import com.example.TaskAuction.data.repository.UserRepository;
import com.example.TaskAuction.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    // Почему нет private???
    @Autowired
    private UserRepository userRepository;

    @Override
    public MessageResponse createEmployee(UserRequest userRequest) {
        User newUser = new User();
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(userRequest.getPassword());
        userRepository.save(newUser);
        return new MessageResponse("New Employee created successfully");
    }

    @Override
    public Optional<User> updateEmployee(Integer employeeId, UserRequest userRequest)  throws ResourceNotFoundException{
        Optional<User> employee = userRepository.findById(employeeId);
        if (employee.isEmpty()){
            throw new ResourceNotFoundException("Employee", "id", employeeId);
        }
        else
            employee.get().setFirstName(userRequest.getFirstName());

        employee.get().setEmail(userRequest.getEmail());
        employee.get().setPassword(userRequest.getPassword());
        userRepository.save(employee.get());
        return employee;
    }

    @Override
    public User getASingleEmployee(Integer employeeId) throws ResourceNotFoundException{
        return userRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    @Override
    public List<User> getAllEmployee() {
        return userRepository.findAll();
    }
    @Override
    public void deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
        if (userRepository.getById(employeeId).getId().equals(employeeId)){
            userRepository.deleteById(employeeId);
        }
        else throw new ResourceNotFoundException("Employee", "id", employeeId);
    }
}