package com.example.TaskAuction.data.repository;

import com.example.TaskAuction.data.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Аннотация Repository не нужна
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
