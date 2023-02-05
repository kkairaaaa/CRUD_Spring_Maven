package com.example.TaskAuction.web;


import com.example.TaskAuction.data.models.User;
import com.example.TaskAuction.data.payloads.request.UserRequest;
import com.example.TaskAuction.data.payloads.response.MessageResponse;
import com.example.TaskAuction.service.UserService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
//Line 19 to 24 is the newly added code for swagger documentation
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllEmployees () {
        List<User> footballers = userService.getAllEmployee();
        return new ResponseEntity<>(footballers, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getEmployeeById (@PathVariable("id") Integer id) {
        User user = userService.getASingleEmployee(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee( @RequestBody UserRequest employee) {
        MessageResponse newEmployee = userService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Optional<User> updateEmployee(@PathVariable Integer id, @RequestBody UserRequest employee) {
        return userService.updateEmployee(id, employee);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        userService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}