package ru.yandex.practicum.smarthome.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry")
@Data
public class Telemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;

    private LocalDateTime producedAt;

    private String telemetryUnit; // можно было enum... но не сделал

    private String data;
}
