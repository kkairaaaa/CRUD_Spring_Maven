package com.example.TaskAuction.data.payloads.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// используй Lombok чтобы автоматически генерировать getters setters и конструкторы
// Аннотация data автоматом добавляет геттеры и сеттеры
@Data
public class UserRequest {
    private String firstName;
    private String lastname;
    private String phoneNumber;
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String password;

}