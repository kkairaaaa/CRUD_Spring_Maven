package com.example.TaskAuction.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;



// Добавить надо аннотацию @AllArgs @NoArgs @Getter @Setter потому что использование Data не рекомендуется для Entity
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private String email;
    private double salary;
    @Enumerated(EnumType.STRING)
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, phoneNumber, email, salary, department);
    }
}