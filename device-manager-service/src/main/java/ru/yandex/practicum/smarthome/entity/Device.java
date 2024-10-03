package ru.yandex.practicum.smarthome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "device")
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

    @ManyToOne(optional = false, targetEntity = House.class)
    private House house;

    @ManyToOne(optional = false, targetEntity = DeviceType.class)
    private DeviceType deviceType;

    private String serial;

    private String name;
}
