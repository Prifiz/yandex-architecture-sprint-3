package ru.yandex.practicum.smarthome.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TelemetryRequestDto {

    private LocalDateTime from;
    private LocalDateTime to;

}
