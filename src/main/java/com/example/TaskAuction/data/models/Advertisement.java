package com.example.TaskAuction.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Добавить надо аннотацию @AllArgs @NoArgs @Getter @Setter потому что использование Data не рекомендуется для Entity
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String header;

    private String description;

    private double minPrice;

    private boolean isActive;
    @OneToOne
    private User owner;

}
