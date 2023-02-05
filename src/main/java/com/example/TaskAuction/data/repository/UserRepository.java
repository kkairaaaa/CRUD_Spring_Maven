package com.example.TaskAuction.data.repository;

import com.example.TaskAuction.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Аннотация Repository не нужна
public interface UserRepository extends JpaRepository<User, Integer> {
}
