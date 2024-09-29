package ru.yandex.practicum.smarthome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // для упрощения, чтобы не тратить время на лишние поля

    // здесь будут прочие данные пользователя на след. этапах
}
