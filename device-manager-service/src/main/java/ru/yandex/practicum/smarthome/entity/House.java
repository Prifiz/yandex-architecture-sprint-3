package ru.yandex.practicum.smarthome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "house")
@Data
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @ManyToOne(optional = false, targetEntity = User.class)
    private User user;
}
