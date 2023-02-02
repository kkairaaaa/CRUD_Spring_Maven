package com.example.TaskAuction.data.payloads.request;


import  com.example.TaskAuction.data.models.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// используй Lombok чтобы автоматически генерировать getters setters и конструкторы
// Аннотация data автоматом добавляет геттеры и сеттеры
@Data
public class EmployeeRequest {
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastname;
    @NotBlank
    @NotNull
    private String phoneNumber;
    @Email
    private String email;
    @NotBlank
    @NotNull
    private double salary;
    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private Department department;

}