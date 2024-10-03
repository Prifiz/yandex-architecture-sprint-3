package ru.yandex.practicum.smarthome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "device_type")
@Data
public class DeviceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
